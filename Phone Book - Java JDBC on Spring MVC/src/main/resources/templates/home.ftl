<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <style>
        div.a {
            position: fixed;
            top: 0%;
            left: 1%;
        }
        div.b {
            position: fixed;
            top: 0%;
            left: 50%;
        }
        div.c {
            position: fixed;
            top: 70%;
            left: 1%;
        }
    </style>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div class="a">
        <p>People</p>
        <table border="1">
            <#list peoples?values as people>
                <tr>
                    <#list people as p>
                    <td> ${p} </td>
                    </#list>
                </tr>
            </#list>
        </table>
    </div>
    <div class="b">
        <p>Phones</p>
        <table border="1">
            <#list phones?values as phone>
                <tr>
                    <#list phone as p>
                        <td> ${p} </td>
                    </#list>
                </tr>
            </#list>
        </table>
    </div>
    <div class="c">
        <p>Peoples Edit:</p>
        <form method="post" action="/home/addperson">
            <label for="id">Id :</label>
            <input type="text" id="id" name="id" required/>
            <label for="first_name">Name:</label>
            <input type="text" id="first_name" name="first_name" required/>
            <label for="second_name">Surname:</label>
            <input type="text" id="second_name" name="second_name" required/>
            <label for="age">Age :</label>
            <input type="text" id="age" name="age" required/>
            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender" required/>
            <button type="submit" >Add Person</button>
        </form>

        <form method="post" action="/home/deleteperson">
            <label for="id">Id :</label>
            <input type="text" id="id" name="id" required/>
            <button type="submit" >Delete Person</button>
        </form>

        <form method="post" action="/home/editperson">
            <label for="id">Id :</label>
            <input type="text" id="id" name="id" required/>
            <button type="submit" >Edit Person</button>
        </form>

        <#if person??>
            <form method="post" action="/home/updateperson">
                <label for="id">Id :${person[0]}</label>
                <input type="text" id="id" name="id" value="${person[0]}" required hidden/>
                <label for="first_name">Name:</label>
                <input type="text" id="first_name" name="first_name" value="${person[1]}" required/>
                <label for="second_name">Surname:</label>
                <input type="text" id="second_name" name="second_name" value="${person[2]}" required/>
                <label for="age">Age :</label>
                <input type="text" id="age" name="age" value="${person[3]}" required/>
                <label for="gender">Gender:</label>
                <input type="text" id="gender" name="gender" value="${person[4]}" required/>
                <button type="submit" >Update Person</button>
            </form>
        </#if>




        <p>Phones Edit:</p>
        <form method="post" action="/home/addphone">
            <label for="id">Id :</label>
            <input type="text" id="id" name="id" required/>
            <label for="number">Number:</label>
            <input type="text" id="number" name="number" required/>
            <label for="person_id">Id of person:</label>
            <input type="text" id="person_id" name="person_id" required/>
            <button type="submit" >Add Phone</button>
        </form>

        <form method="post" action="/home/deletephone">
            <label for="id">Id :</label>
            <input type="text" id="id" name="id" required/>
            <button type="submit" >Delete Phone</button>
        </form>


        <form method="post" action="/home/editphone">
            <label for="id">Id :</label>
            <input type="text" id="id" name="id" required/>
            <button type="submit" >Edit Phone</button>
        </form>

        <#if phone??>
            <form method="post" action="/home/updatephone">
                <label for="id">Id :${phone[0]}</label>
                <input type="text" id="id" name="id" value="${phone[0]}" required hidden/>
                <label for="number">Name:</label>
                <input type="text" id="number" name="number" value="${phone[1]}" required/>
                <label for="person_id">Surname:</label>
                <input type="text" id="person_id" name="person_id" value="${phone[2]}" required/>
                <button type="submit" >Update Person</button>
            </form>
        </#if>


    </div>

</body>
</html>