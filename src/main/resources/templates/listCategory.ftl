
<#--<script type="text/javascript" src="js/jquery.min.js"></script>-->
<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>

    <#if page??>
        <#list page.list as category>
         <tr>
             <td>${category.id}</td>
             <td>${category.name}</td>
             <td><a href="editCategory?id=${category.id}">编辑</a></td>
             <td><a href="deleteCategory?id=${category.id}">删除</a></td>
         </tr>
        </#list>
    </#if>
    </table>

    <br>
    <div>
        <a href="?start=1">[首 页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末 页]</a>
        <div >
            第${page.pageNum} 页，共${page.pages}页，每页显示 ${page.pageSize} 条记录，共 ${page.total} 条记录
        </div>
    </div>
    <br>
    <form action="addCategory" method="post">

        name: <input name="name"> <br>
        <button type="submit">提交</button>

    </form>
</div>