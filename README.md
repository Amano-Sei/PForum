# PForum

属实一波三折...是为了最后的大作业顺便学习下git和github建的仓库，然后一个不小心自己差不多一天多的成果全没了QAQ虽然借助git恢复了，真的就是一念之间差点连恢复的机会都没了(<br>
室友们似乎都不想好好做，恕我直言，做的都是什么辣鸡←你做的也是辣鸡哦<br>
为了方便管理进度，我还建了个数据库...按照(现在)预期的文件数，现在进度是30%<br>
预期这周再完成30%左右，因为涉及一些自己没有试过的东西，参考两天30%，大概还要最少5天左右（什么都不干的那种）<br>
jojo我不复习了！<br><br>
+-----+----------+---------+---------------------------+--------------------------------+------+<br>
| pid | maintype | type    | belong                    | fname                          | done |<br>
+-----+----------+---------+---------------------------+--------------------------------+------+<br>
|   1 | 后端     | filter  | sei.amano.admin.filter;   | AdminFilter.java               |    0 |<br>
|   2 | 后端     | servlet | sei.amano.admin.servlet   | AdminBlackListServlet.java     |    0 |<br>
|   3 | 后端     | servlet | sei.amano.admin.servlet   | AdminBlockCategoryServlet.java |    0 |<br>
|   4 | 后端     | servlet | sei.amano.admin.servlet   | AdminBlockServlet.java         |    0 |<br>
|   5 | 后端     | servlet | sei.amano.admin.servlet   | AdminChainingServlet.java      |    0 |<br>
|   6 | 后端     | servlet | sei.amano.admin.servlet   | AdminServlet.java              |    0 |<br>
|   7 | 后端     | servlet | sei.amano.admin.servlet   | AdminUserServlet.java          |    0 |<br>
|   8 | 后端     | bean    | sei.amano.bean            | Block.java                     |    1 |<br>
|   9 | 后端     | bean    | sei.amano.bean            | BlockCategory.java             |    1 |<br>
|  10 | 后端     | bean    | sei.amano.bean            | BlockCategoryInBlock.java      |    1 |<br>
|  11 | 后端     | bean    | sei.amano.bean            | BlockInBlockCategory.java      |    1 |<br>
|  12 | 后端     | bean    | sei.amano.bean            | Chaining.java                  |    1 |<br>
|  13 | 后端     | bean    | sei.amano.bean            | Posting.java                   |    1 |<br>
|  14 | 后端     | bean    | sei.amano.bean            | User.java                      |    1 |<br>
|  15 | 后端     | filter  | sei.amano.content.filter  | ChainingFilter.java            |    0 |<br>
|  16 | 后端     | filter  | sei.amano.content.filter  | HomeFilter.java                |    0 |<br>
|  17 | 后端     | servlet | sei.amano.content.servlet | AddPostingServlet.java         |    0 |<br>
|  18 | 后端     | servlet | sei.amano.content.servlet | EditPostingServlet.java        |    0 |<br>
|  19 | 后端     | dao     | sei.amano.dao             | BlacklistDAO.java              |    1 |<br>
|  20 | 后端     | dao     | sei.amano.dao             | BlockCategoryDAO.java          |    1 |<br>
|  21 | 后端     | dao     | sei.amano.dao             | BlockCategoryInBlockDAO.java   |    1 |<br>
|  22 | 后端     | dao     | sei.amano.dao             | BlockDAO.java                  |    1 |<br>
|  23 | 后端     | dao     | sei.amano.dao             | BlockInBlockCategoryDAO.java   |    1 |<br>
|  24 | 后端     | dao     | sei.amano.dao             | ChainingDAO.java               |    1 |<br>
|  25 | 后端     | dao     | sei.amano.dao             | PostingDAO.java                |    1 |<br>
|  26 | 后端     | dao     | sei.amano.dao             | ULvNameDAO.java                |    1 |<br>
|  27 | 后端     | dao     | sei.amano.dao             | UserDAO.java                   |    1 |<br>
|  28 | 后端     | filter  | sei.amano.filter          | BlacklistFilter.java           |    0 |<br>
|  29 | 后端     | filter  | sei.amano.filter          | EncodingFilter.java            |    0 |<br>
|  30 | 后端     | filter  | sei.amano.filter          | LoginFilter.java               |    0 |<br>
|  31 | 后端     | servlet | sei.amano.servlet         | VerificationServlet.java       |    0 |<br>
|  32 | 后端     | filter  | sei.amano.user.filter     | ChainingListFilter.java        |    0 |<br>
|  33 | 后端     | filter  | sei.amano.user.filter     | ModifyFilter.java              |    0 |<br>
|  34 | 后端     | filter  | sei.amano.user.filter     | StatusFilter.java              |    0 |<br>
|  35 | 后端     | servlet | sei.amano.user.servlet    | ChangePasswordServlet.java     |    0 |<br>
|  36 | 后端     | servlet | sei.amano.user.servlet    | EditServlet.java               |    0 |<br>
|  37 | 后端     | servlet | sei.amano.user.servlet    | LoginServlet.java              |    0 |<br>
|  38 | 后端     | servlet | sei.amano.user.servlet    | LogoutServlet.java             |    0 |<br>
|  39 | 后端     | servlet | sei.amano.user.servlet    | RegisterServlet.java           |    0 |<br>
|  40 | 后端     | util    | sei.amano.util            | DateUtil.java                  |    1 |<br>
|  41 | 后端     | util    | sei.amano.util            | DBUtil.java                    |    1 |<br>
|  42 | 后端     | util    | sei.amano.util            | KWUtil.java                    |    1 |<br>
|  43 | 后端     | util    | sei.amano.util            | MD5Util.java                   |    1 |<br>
|  44 | 前端     | jsp     | /web                      | home.jsp                       |    0 |<br>
|  45 | 前端     | jsp     | /web/admin/blacklist      | list.jsp                       |    0 |<br>
|  46 | 前端     | jsp     | /web/admin/block          | edit.jsp                       |    0 |<br>
|  47 | 前端     | jsp     | /web/admin/block          | list.jsp                       |    0 |<br>
|  48 | 前端     | jsp     | /web/admin/blockcategory  | edit.jsp                       |    0 |<br>
|  49 | 前端     | jsp     | /web/admin/blockcategory  | list.jsp                       |    0 |<br>
|  50 | 前端     | jsp     | /web/admin/chaining       | list.jsp                       |    0 |<br>
|  51 | 前端     | jsp     | /web/admin/posting        | list.jsp                       |    0 |<br>
|  52 | 前端     | jsp     | /web/admin/user           | list.jsp                       |    0 |<br>
|  53 | 前端     | jsp     | /web/content              | chaining.jsp                   |    0 |<br>
|  54 | 前端     | jsp     | /web/include/admin        | footer.jsp                     |    0 |<br>
|  55 | 前端     | jsp     | /web/include/admin        | header.jsp                     |    0 |<br>
|  56 | 前端     | jsp     | /web/include/admin        | nav.jsp                        |    0 |<br>
|  57 | 前端     | jsp     | /web/include/admin        | pag.jsp                        |    0 |<br>
|  58 | 前端     | jsp     | /web/include/content      | footer.jsp                     |    0 |<br>
|  59 | 前端     | jsp     | /web/include/content      | header.jsp                     |    0 |<br>
|  60 | 前端     | jsp     | /web/include/content      | nav.jsp                        |    0 |<br>
|  61 | 前端     | jsp     | /web/include/content      | pag.jsp                        |    0 |<br>
|  62 | 前端     | jsp     | /web/user                 | login.jsp                      |    0 |<br>
|  63 | 前端     | jsp     | /web/user                 | register.jsp                   |    0 |<br>
|  64 | 前端     | jsp     | /web/user/manage          | chainlist.jsp                  |    0 |<br>
|  65 | 前端     | jsp     | /web/user/manage          | modify.jsp                     |    0 |<br>
|  66 | 前端     | jsp     | /web/user/manage          | postinglist.jsp                |    0 |<br>
|  67 | 前端     | jsp     | /web/user/manage          | status.jsp                     |    0 |<br>
+-----+----------+---------+---------------------------+--------------------------------+------+<br>
