const invreg = /is-invalid/;
const vreg = /is-valid/;
var invcnt = 0;

const ubirthpattern = /^(19[0-9][0-9]|200[0-9]|201[0-8])-((?<=(19([02468][048]|[13579][26])|200[048]|201[26])-)02-29|02-([01][1-9]|10|2[0-8])|(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01])|(0[469]|11)-(0[1-9]|[12][0-9]|30))$/;
//哼哧哼哧熬夜吐血写了个正则，其实写的时候已经知道可以用Date了，但是为了加强正则的能力...还是手动哼哧哼哧了（
const uhobbypattern = /^([^\x00-\xff]|\w)([^\x00-\xff]|\w| ){0,58}([^\x00-\xff]|\w)$/;
const usignatruepattern = /^([^\x00-\xff]|\w| ){2,256}$/;

$(function(){
	$("input").each(function(){
		if($($(this)).attr("required")){
			if(!vreg.test($(this).attr("class")))
				invcnt++;
		}else{
			if(invreg.test($(this).attr("class")))
				invcnt++;
		}
	});
	if(!$(":radio")[0].checkValidity())
		invcnt -= 2;
	$("#invlast").text(invcnt);

	$("input:radio").click(function(){
		if(this.checkValidity()){
			if(!vreg.test($(this).attr("class")))
				invcnt--;
			$("#male").removeClass("is-invalid");
			$("#male").addClass("is-valid");
			$("#female").removeClass("is-invalid");
			$("#female").addClass("is-valid");
			$("#secret").removeClass("is-invalid");
			$("#secret").addClass("is-valid");
			$("#ausex").removeClass("text-danger");
			$("#ausex").removeClass("border-danger");
			$("#ausex").addClass("text-success");
			$("#ausex").addClass("border-success");
		}else{
			if(vreg.test($(this).attr("class")))
				invcnt++;
			$("#male").removeClass("is-valid");
			$("#male").addClass("is-invalid");
			$("#female").removeClass("is-valid");
			$("#female").addClass("is-invalid");
			$("#secret").removeClass("is-valid");
			$("#secret").addClass("is-invalid");
			$("#ausex").addClass("text-danger");
			$("#ausex").removeClass("text-success");
			$("#ausex").removeClass("border-success");
			$("#ausex").addClass("border-danger");
		}
		$("#invlast").text(invcnt);
	});

	$("#uagree").change(function(){
		if(this.checkValidity()){
			if(!vreg.test($(this).attr("class")))
				invcnt--;
			$(this).removeClass("is-invalid");
			$(this).addClass("is-valid");
			$("#auagree").removeClass("text-danger");
			$("#auagree").removeClass("border-danger");
			$("#auagree").addClass("text-success");
			$("#auagree").addClass("border-success");
		}else{
			if(vreg.test($(this).attr("class")))
				invcnt++;
			$(this).removeClass("is-valid");
			$(this).addClass("is-invalid");
			$("#auagree").addClass("text-danger");
			$("#auagree").removeClass("text-success");
			$("#auagree").removeClass("border-success");
			$("#auagree").addClass("border-danger");
		}
		$("#invlast").text(invcnt);
	});

	$("#uprofile").change(function(){
		$(this).next().text(!$(this)[0].files||$(this)[0].files.length==0 ? "上传头像..." : $(this)[0].files[0].name);
		$(this).parent().addClass("mb-4");
		if(!$(this)[0].files || $(this)[0].files.length==0 || ($(this)[0].files[0].name.endsWith(".jpg") && $(this)[0].files[0].size <= 1048576)){
			if(invreg.test($(this).attr("class")))
				invcnt--;
			$(this).removeClass("is-invalid");
			$(this).addClass("is-valid");
			$("#auprofile").removeClass("text-danger");
			$("#auprofile").removeClass("border-danger");
			$("#auprofile").addClass("text-success");
			$("#auprofile").addClass("border-success");
		}else{
			if(!invreg.test($(this).attr("class")))
				invcnt++;
			$(this).removeClass("is-valid");
			$(this).addClass("is-invalid");
			$("#auprofile").addClass("text-danger");
			$("#auprofile").removeClass("text-success");
			$("#auprofile").removeClass("border-success");
			$("#auprofile").addClass("border-danger");
		}
		$("#invlast").text(invcnt);
	});

	$("#ubirth").change(function(){
		//var tbirth = new Date($("#ubirth").val());
		//想了下还是正则比较方便诶...
		//然后发觉好像这个chrome下没必要...
		var sbirth = $(this).val();
		if(sbirth = '' || ubirthpattern.test(sbirth)){
			if(invreg.test($(this).attr("class")))
				invcnt--;
			$(this).removeClass("is-invalid");
			$(this).addClass("is-valid");
			$("#aubirth").removeClass("text-danger");
			$("#aubirth").removeClass("border-danger");
			$("#aubirth").addClass("text-success");
			$("#aubirth").addClass("border-success");
		}else{
			if(!invreg.test($(this).attr("class")))
				invcnt++;
			$(this).removeClass("is-valid");
			$(this).addClass("is-invalid");
			$("#aubirth").addClass("text-danger");
			$("#aubirth").removeClass("text-success");
			$("#aubirth").removeClass("border-success");
			$("#aubirth").addClass("border-danger");
		}
		$("#invlast").text(invcnt);
	});

	$("#uhobby").change(function(){
		var shobby = $(this).val();
		if(shobby = '' || uhobbypattern.test(shobby)){
			if(invreg.test($(this).attr("class")))
				invcnt--;
			$(this).removeClass("is-invalid");
			$(this).addClass("is-valid");
			$("#auhobby").removeClass("text-danger");
			$("#auhobby").removeClass("border-danger");
			$("#auhobby").addClass("text-success");
			$("#auhobby").addClass("border-success");
		}else{
			if(!invreg.test($(this).attr("class")))
				invcnt++;
			$(this).removeClass("is-valid");
			$(this).addClass("is-invalid");
			$("#auhobby").addClass("text-danger");
			$("#auhobby").removeClass("text-success");
			$("#auhobby").removeClass("border-success");
			$("#auhobby").addClass("border-danger");
		}
		$("#invlast").text(invcnt);
	});

	$("#usignatrue").blur(function(){
		var ssignatrue = $(this).val();
		if(ssignatrue = '' || usignatruepattern.test(ssignatrue)){
			if(invreg.test($(this).attr("class")))
				invcnt--;
			$(this).removeClass("is-invalid");
			$(this).addClass("is-valid");
			$("#ausignatrue").removeClass("text-danger");
			$("#ausignatrue").removeClass("border-danger");
			$("#ausignatrue").addClass("text-success");
			$("#ausignatrue").addClass("border-success");
		}else{
			if(!invreg.test($(this).attr("class")))
				invcnt++;
			$(this).removeClass("is-valid");
			$(this).addClass("is-invalid");
			$("#ausignatrue").addClass("text-danger");
			$("#ausignatrue").removeClass("text-success");
			$("#ausignatrue").removeClass("border-success");
			$("#ausignatrue").addClass("border-danger");
		}
		$("#invlast").text(invcnt);
	});
});
