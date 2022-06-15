<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div >
            <h1>Search user</h1>
            <a href = "">Main menu</a>
            <a href = "">Logout</a>
        </div>

        <form action="Calculator">


            <p>Username: </p>
            <input type="text" name="username">
            <p>Password: </p>
            <input type="text" name="password">
            <p>Confirm password: </p>
            <input type="text" name="confirmpassword">
            
            <p>First name: </p>
            <input type="text" name="firstname">
            <p>Last name: </p>
            <input type="text" name="lastname">
            <p>Sex: </p>
            <input type="text" name="sex">
            
            <p>Address: </p>
            <input type="text" name="address">
            <p>Email: </p>
            <input type="text" name="email">
            <p>Mobile-phone </p>
            <input type="text" name="mobile-phone">
          
            <br>
            <br>
            <button type="button">Search</button>
        </form>
        
        
        <br>
        <h1>The matching list</h1>
        <table style="border: 1px solid black; width: 100%;">
            <tr>
                <th>User name</th>
                <th>Password</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Sex</th>
                <th>Address</th>
                <th>Email</th>
                <th>Mobile-phone</th>
                <th>Role-name</th>
                <th></th>
            </tr>
           
            <tr>
                <td>User name</td>
                <td>Password</td>
                <td>First name</td>
                <td>User name</td>
                <td>Password</td>
                <td>First name</td>
                <td>User name</td>
                <td>Password</td>
                <td>First name</td>
                <td>
                    <input type="checkbox" value=""/>
                </td>
            </tr>
        </table>
         <br>
         <button type="button">Back</button>
          <button type="button">Create</button>
           <button type="button">Delete</button>
    </body>
</html>
