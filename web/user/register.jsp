<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/splib.jsp" %>
<link rel="stylesheet" href="/PForum/css/user/register.css">
<script type="text/javascript" src="/PForum/js/user/register.js"></script>
<title>注册</title>
</head>
<body>
	<div class="container">
		<div class="py-5 text-center">
			<a href="/PForum/home.jsp"><img class="rounded d-block mx-auto mb-4" src="/PForum/img/page/icon.png" alt="PForum" width="72" height="72"></a>
			<h2>注册</h2>
			<p class="lead">欢迎来到PForum，虽然说实话本来就没打算当成作业来做，但是要和期末考试做二择实在是意料之外，以下是注册表单（已经有点想丢之前做的半成品交作业了...）<br>需要注意必填是必填的，选填要么不填要么必须有效。</p>
		</div>
		<form action="/PForum/registerServlet" method="post" class="needs-validation row" novalidate>
			<div class="col-md-9">
				<h4 class="row">必填</h4>
				<div class="row">
					<label for="uname">用户名：</label>
					<input type="text" class="form-control ${param.erruname }" id="uname" name="uname" placeholder="请输入5~16位的用户名" value="${param.uname }" required pattern="^[a-zA-Z]\w{4,15}$">
					<div class="valid-feedback">nice</div>
					<div class="invalid-feedback">用户名只能为5~16位的字母或下划线且只能以字母开头!</div>
				</div>
				<div class="row">
					<label for="upassword">密码：</label>
					<input type="password" class="form-control ${param.errupassword }" id="upassword" name="upassword" placeholder="请输入8~20位的密码" value="" required pattern="^[+!@#$%^&/?><,\(\)\[\]\{\}\.\*\-\=\\\w]{8,20}$">
					<div class="valid-feedback">nice</div>
					<div class="invalid-feedback">密码只能为8~20位的+!@#$%^&/?><,()[]{}.*-=_\或字母!</div>
				</div>
				<div class="row">
					<label for="reupassword">重复密码：</label>
					<input type="password" class="form-control ${param.errreupassword }" id="reupassword" name="reupassword" placeholder="请再次输入密码" value="" required>
					<div class="valid-feedback">nice</div>
					<div class="invalid-feedback">两次输入的密码不同!</div>
				</div>
				<div class="row">
					<label for="unickname">昵称：</label>
					<input type="text" class="form-control ${param.errunickname }" id="unickname" name="unickname" placeholder="请输入昵称" value="${param.unickname}" pattern="^([^\x00-\xff]|\w)([^\x00-\xff]|\w| ){0,14}([^\x00-\xff]|\w)$" required>
					<div class="valid-feedback">nice</div>
					<div class="invalid-feedback">昵称为2~16位的汉字或者字符或者下划线或者空格切不能以空格为开头或结尾!</div>
				</div>
				<div class="row">
					<label for="umail">邮箱：</label>
					<input type="email" class="form-control ${param.errumail }" id="umail" name="umail" placeholder="请输入邮箱" value="${param.umail}" pattern="^\w+\@(\w+.)+\w+$" required>
					<div class="valid-feedback">nice</div>
					<div class="invalid-feedback">请输入正确的邮箱!</div>
				</div>
				<div class="row">
					<label for="secret">性别：</label>
				</div>
				<div class="row">
					<div class="custom-control custom-radio ml-3 col-md-3">
						<input type="radio" class="custom-control-input ${param.errusex }" id="male" name="usex" value="male" required>
						<label class="custom-control-label" for="male">男</label>
						<div class="valid-feedback">nice</div>
						<div class="invalid-feedback">保密也是可以鸭</div>
					</div>
					<div class="custom-control custom-radio col-md-3">
						<input type="radio" class="custom-control-input ${param.errusex }" id="female" name="usex" value="female" required>
						<label class="custom-control-label" for="female">女</label>
					</div>
					<div class="custom-control custom-radio col-md-3">
						<input type="radio" class="custom-control-input ${param.errusex }" id="secret" name="usex" value="secret" required>
						<label class="custom-control-label" for="secret">保密</label>
					</div>
				</div>
				
				<div class="row">
					<label for="uagree">协议：</label>
					<div class="custom-control custom-checkbox ml-5">
						<input type="checkbox" class="custom-control-input ${param.erruagree }" id="uagree" name="uagree" value="on" ${param.uagree } required>
						<label class="custom-control-label" for="uagree">我不是臭dd。</label>
							<div class="valid-feedback">nice</div>
							<div class="invalid-feedback">dd滚开啊</div>
					</div>
				</div>

				<hr class="mb-1 row">

				<h4 class="row mt-2">选填</h4>
				<div class="row">
					<label for="uprofile">头像：</label>
					<div class="custom-file">
						<input type="file" class="custom-file-input ${param.errreupassword }" id="uprofile" name="uprofile" accept="image/jpeg">
						<label class="custom-file-label" for="uprofile">上传头像...</label>
						<div class="valid-feedback mt-3">nice</div>
						<div class="invalid-feedback mt-3">头像大小不能超过1m，且必须为jpg文件</div>
					</div>
				</div>
				<div class="row">
					<label for="ubirth">生日：</label>
					<input type="date" class="form-control ${param.errubirth }" value="${param.ubirth }" id="ubirth" name="ubirth" min="1900-01-01" max="2019-6-21">
					<div class="valid-feedback">nice，需要注意据已知最少chrome不会产生无效的日期，所以如果是无效的生日的话请当做你没有填</div>
					<div class="invalid-feedback">格式需要形如"yyyy-MM-dd"，否则按照常理来说是不可能存在的的生日！（当然如果是正确的生日请联系管理员，同时给老先生您道个歉，对不起）</div>
				</div>
				<div class="row">
					<label for="uhobby">爱好：</label>
					<input type="text" class="form-control ${param.erruhobby }" id="uhobby" name="uhobby" placeholder="请输入爱好" value="${param.uhobby}">
					<div class="valid-feedback">nice</div>
					<div class="invalid-feedback">爱好需要为2~60位双字节字符（你可以当做是中文）或英文字符或下划线或空格且不能以空格开头或结尾！</div>
				</div>
				<div class="row">
					<label for="usignatrue">个性签名：</label>
					<textarea class="form-control ${param.errusignature }" id="usignatrue" name="usignatrue" placeholder="这个人很懒，什么都没有留下">${param.usignature}</textarea>
					<div class="valid-feedback">nice</div>
					<div class="invalid-feedback">个性签名的限制为2~256个字符</div>
				</div>
			</div>
			
			<nav class="col-md-3 position-sticky">
				<h6 class="d-flex justify-content-between align-items-center mb-3">
					<a class="text-muted" href="#">剩余</a>
					<span class="badge badge-secondary badge-pill" id="invlast">7</span>
				</h6>
				<div class="list-group mb-3 lh-1 small">
					<a id="auname" href="#uname" class='list-group-item list-group-item-action ${param.erruname==null? "text-muted" : (param.erruname=="is-valid" ? "text-success border-success" : "text-danger border-danger")}'>用户名</a>
					<a id="aupassword" href="#upassword" class='list-group-item list-group-item-action ${param.errupassword==null? "text-muted" : (param.errupassword=="is-valid" ? "text-success border-success" : "text-danger border-danger")}'>密码</a>
					<a id="areupassword" href="#reupassword" class='list-group-item list-group-item-action ${param.errreupassword==null? "text-muted" : (param.errreupassword=="is-valid" ? "text-success border-success" : "text-danger border-danger")}'>重复密码</a>
					<a id="aunickname" href="#unickname" class='list-group-item list-group-item-action ${param.errunickname==null? "text-muted" : (param.errunickname=="is-valid" ? "text-success border-success" : "text-danger border-danger")}'>昵称</a>
					<a id="aumail" href="#umail" class='list-group-item list-group-item-action ${param.errumail==null? "text-muted" : (param.errumail=="is-valid" ? "text-success border-success" : "text-danger border-danger")}'>邮箱</a>
					<a id="ausex" href="#secret" class='list-group-item list-group-item-action ${param.errusex==null? "text-muted" : (param.errusex=="is-valid" ? "text-success border-success" : "text-danger border-danger")}'>性别</a>
					<a id="auagree" href="#uagree" class='list-group-item list-group-item-action ${param.erruagree==null? "text-muted" : (param.erruagree=="is-valid" ? "text-success border-success" : "text-danger border-danger")}'>协议</a>
					<a id="auprofile" href="#uprofile" class='list-group-item list-group-item-action ${param.erruprofile==null||param.erruprofile=="is-valid" ? "text-success border-success" : "text-danger border-danger"}'>头像</a>
					<a id="aubirth" href="#ubirth" class='list-group-item list-group-item-action ${param.errubirth==null||param.errubirth=="is-valid" ? "text-success border-success" : "text-danger border-danger"}'>生日</a>
					<a id="auhobby" href="#uhobby" class='list-group-item list-group-item-action ${param.erruhobby==null||param.erruhobby=="is-valid" ? "text-success border-success" : "text-danger border-danger"}'>爱好</a>
					<a id="ausignatrue" href="#usignatrue" class='list-group-item list-group-item-action ${param.errusignatrue==null||param.errusignatrue=="is-valid" ? "text-success border-success" : "text-danger border-danger"}'>个性签名</a>
				</div>
				<div class="d-flex justify-content-around">
					<button type="submit" class="btn btn-outline-primary">注册</button>
					<button type="reset" class="btn btn-outline-success">重置</button>
				</div>
			</nav>
		</form>
	</div>
	<footer class="my-5 pt-5 text-muted text-center text-small">
		<p class="mb-1">made by Amano Sei</p>
		<p>一个下午终于完成了html部分...还有难点的js部分绝望...</p>
	</footer>
</body>
</html>