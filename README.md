# PForum

属实一波三折...是为了最后的大作业顺便学习下git和github建的仓库，然后一个不小心自己差不多一天多的成果全没了QAQ虽然借助git恢复了，真的就是一念之间差点连恢复的机会都没了(<br>
室友们似乎都不想好好做，恕我直言，做的都是什么辣鸡←你做的也是辣鸡哦<br>
为了方便管理进度，我还建了个数据库...按照(现在)预期的文件数，现在进度是30%<br>
预期这周再完成30%左右，因为涉及一些自己没有试过的东西，参考两天30%，大概还要最少5天左右（什么都不干的那种）<br>
jojo我不复习了！<br>
<pre>
+-----+----------+---------+---------------------------+--------------------------------+------+
| pid | maintype | type    | belong                    | fname                          | done |
+-----+----------+---------+---------------------------+--------------------------------+------+
|   1 | 后端     | filter  | sei.amano.admin.filter;   | AdminFilter.java               |    0 |
|   2 | 后端     | servlet | sei.amano.admin.servlet   | AdminBlackListServlet.java     |    0 |
|   3 | 后端     | servlet | sei.amano.admin.servlet   | AdminBlockCategoryServlet.java |    0 |
|   4 | 后端     | servlet | sei.amano.admin.servlet   | AdminBlockServlet.java         |    0 |
|   5 | 后端     | servlet | sei.amano.admin.servlet   | AdminChainingServlet.java      |    0 |
|   6 | 后端     | servlet | sei.amano.admin.servlet   | AdminServlet.java              |    0 |
|   7 | 后端     | servlet | sei.amano.admin.servlet   | AdminUserServlet.java          |    0 |
|   8 | 后端     | bean    | sei.amano.bean            | Block.java                     |    1 |
|   9 | 后端     | bean    | sei.amano.bean            | BlockCategory.java             |    1 |
|  10 | 后端     | bean    | sei.amano.bean            | BlockCategoryInBlock.java      |    1 |
|  11 | 后端     | bean    | sei.amano.bean            | BlockInBlockCategory.java      |    1 |
|  12 | 后端     | bean    | sei.amano.bean            | Chaining.java                  |    1 |
|  13 | 后端     | bean    | sei.amano.bean            | Posting.java                   |    1 |
|  14 | 后端     | bean    | sei.amano.bean            | User.java                      |    1 |
|  15 | 后端     | filter  | sei.amano.content.filter  | ChainingFilter.java            |    0 |
|  16 | 后端     | filter  | sei.amano.content.filter  | HomeFilter.java                |    0 |
|  17 | 后端     | servlet | sei.amano.content.servlet | AddPostingServlet.java         |    0 |
|  18 | 后端     | servlet | sei.amano.content.servlet | EditPostingServlet.java        |    0 |
|  19 | 后端     | dao     | sei.amano.dao             | BlacklistDAO.java              |    1 |
|  20 | 后端     | dao     | sei.amano.dao             | BlockCategoryDAO.java          |    1 |
|  21 | 后端     | dao     | sei.amano.dao             | BlockCategoryInBlockDAO.java   |    1 |
|  22 | 后端     | dao     | sei.amano.dao             | BlockDAO.java                  |    1 |
|  23 | 后端     | dao     | sei.amano.dao             | BlockInBlockCategoryDAO.java   |    1 |
|  24 | 后端     | dao     | sei.amano.dao             | ChainingDAO.java               |    1 |
|  25 | 后端     | dao     | sei.amano.dao             | PostingDAO.java                |    1 |
|  26 | 后端     | dao     | sei.amano.dao             | ULvNameDAO.java                |    1 |
|  27 | 后端     | dao     | sei.amano.dao             | UserDAO.java                   |    1 |
|  28 | 后端     | filter  | sei.amano.filter          | BlacklistFilter.java           |    1 |
|  29 | 后端     | filter  | sei.amano.filter          | EncodingFilter.java            |    1 |
|  30 | 后端     | filter  | sei.amano.filter          | LoginFilter.java               |    1 |
|  31 | 后端     | servlet | sei.amano.servlet         | VerificationServlet.java       |    0 |
|  32 | 后端     | filter  | sei.amano.user.filter     | ChainingListFilter.java        |    0 |
|  33 | 后端     | filter  | sei.amano.user.filter     | ModifyFilter.java              |    0 |
|  34 | 后端     | filter  | sei.amano.user.filter     | StatusFilter.java              |    0 |
|  35 | 后端     | servlet | sei.amano.user.servlet    | ChangePasswordServlet.java     |    0 |
|  36 | 后端     | servlet | sei.amano.user.servlet    | EditServlet.java               |    0 |
|  37 | 后端     | servlet | sei.amano.user.servlet    | LoginServlet.java              |    1 |
|  38 | 后端     | servlet | sei.amano.user.servlet    | LogoutServlet.java             |    1 |
|  39 | 后端     | servlet | sei.amano.user.servlet    | RegisterServlet.java           |    1 |
|  40 | 后端     | util    | sei.amano.util            | DateUtil.java                  |    1 |
|  41 | 后端     | util    | sei.amano.util            | DBUtil.java                    |    1 |
|  42 | 后端     | util    | sei.amano.util            | KWUtil.java                    |    1 |
|  43 | 后端     | util    | sei.amano.util            | MD5Util.java                   |    1 |
|  44 | 前端     | jsp     | /web                      | home.jsp                       |    0 |
|  45 | 前端     | jsp     | /web/admin/blacklist      | list.jsp                       |    0 |
|  46 | 前端     | jsp     | /web/admin/block          | edit.jsp                       |    0 |
|  47 | 前端     | jsp     | /web/admin/block          | list.jsp                       |    0 |
|  48 | 前端     | jsp     | /web/admin/blockcategory  | edit.jsp                       |    0 |
|  49 | 前端     | jsp     | /web/admin/blockcategory  | list.jsp                       |    0 |
|  50 | 前端     | jsp     | /web/admin/chaining       | list.jsp                       |    0 |
|  51 | 前端     | jsp     | /web/admin/posting        | list.jsp                       |    0 |
|  52 | 前端     | jsp     | /web/admin/user           | list.jsp                       |    0 |
|  53 | 前端     | jsp     | /web/content              | chaining.jsp                   |    0 |
|  54 | 前端     | include | /web/include/admin        | footer.jsp                     |    0 |
|  55 | 前端     | include | /web/include/admin        | header.jsp                     |    0 |
|  56 | 前端     | include | /web/include/admin        | nav.jsp                        |    0 |
|  57 | 前端     | include | /web/include/admin        | pag.jsp                        |    0 |
|  58 | 前端     | include | /web/include/content      | footer.jsp                     |    0 |
|  59 | 前端     | include | /web/include/content      | header.jsp                     |    0 |
|  60 | 前端     | include | /web/include/content      | nav.jsp                        |    0 |
|  61 | 前端     | include | /web/include/content      | pag.jsp                        |    0 |
|  62 | 前端     | jsp     | /web/user                 | login.jsp                      |    1 |
|  63 | 前端     | jsp     | /web/user                 | register.jsp                   |    1 |
|  64 | 前端     | jsp     | /web/user/manage          | chainlist.jsp                  |    0 |
|  65 | 前端     | jsp     | /web/user/manage          | modify.jsp                     |    0 |
|  66 | 前端     | jsp     | /web/user/manage          | postinglist.jsp                |    0 |
|  67 | 前端     | jsp     | /web/user/manage          | status.jsp                     |    0 |
|  68 | 后端     | util    | sei.amano.util            | IPUtil.java                    |    1 |
|  69 | 前端     | html    | /web                      | error.html                     |    1 |
|  70 | 前端     | css     | /css                      | style.css                      |    0 |
|  71 | 后端     | bean    | sei.amano.bean            | BlackList.java                 |    1 |
|  72 | 前端     | include | /web/include              | splib.jsp                      |    1 |
|  73 | 后端     | servlet | sei.amano.user.servlet    | ChecknameServlet.java          |    1 |
|  74 | 后端     | util    | sei.amano.util            | ParamUtil.java                 |    1 |
+-----+----------+---------+---------------------------+--------------------------------+------+
</pre>

last update 2019-06-22 夜<br>
最后完成的文件: RegisterServlet.java<br>
感觉自己不能再超荷工作了...主要是容易出bug，差不多决定了（要拿半成品交了！<br>
一个难点一做就是一天，接下来后台两天用户自我管理一天主页一天半帖子页一天半<br>
做不完的...这就是现实，再熬夜吐血不复习也做不完的，最主要的是这样bug越来越多<br>
还是假期慢慢做吧<br>
惊了居然JavaScript代码突然就占了一半...果然我的js学的是狗屎QAQ<br>
半成品是指自己之前给自己做的练习，不过当大作业交还是绰绰有余的<br>
<br>
last update 2019-06-23 晨<br>
最后修改的文件: register.js<br>
改变了主意不再每次更新后删除last update部分，而是保留←准备把readme当日记写的某人<br>
毕竟自己js都没有学好，jquery更是一边百度一边用的，然后修正了一点小bug，至此register部分除了省市县应该彻底结束了（测试点都测试过应该，嗯...应该）<br>
