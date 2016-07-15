<%--
  Created by IntelliJ IDEA.
  User: APuzikov
  Date: 7/15/2016
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
    <h2>Create a free Spitter account</h2>
    <sf:form method="POST" modelAttribute="spitter" enctype="multipart/form-data">
        <fieldset>
            <table>
                <tr>
                    <th><sf:label path="fullName">Full name:</sf:label></th>
                    <td><sf:input path="fullName" size="15"/> <br>
                        <sf:errors cssClass="error" path="fullName"/></td>
                </tr>
                <tr>
                    <th><sf:label path="name">Username:</sf:label></th>
                    <td><sf:input path="name" size="15"/>
                        <small id="username_msg">No spaces please.</small>
                        <br>
                        <sf:errors cssClass="error" path="name"/>
                    </td>
                </tr>
                <tr>
                    <th><sf:label path="password">Password:</sf:label></th>
                    <td><sf:password path="password" size="30"/>
                        <small>6 characters or more!</small>
                        <br>
                        <sf:errors cssClass="error" path="password"/>
                    </td>
                </tr>
                <tr>
                    <th><sf:label path="email">Email Address:</sf:label></th>
                    <td><sf:input path="email" size="30"/><br>
                        <sf:errors cssClass="error" path="email"/>
                    </td>
                </tr>
                <tr>
                    <th><sf:label path="emailUpdates">Send me email updates!</sf:label></th>
                    <td><sf:checkbox path="emailUpdates"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="image">Profileimage:</label></th>
                    <td><input name="image" type="file"/>
                </tr>
                <tr>
                    <td>
                        <input name="commit" type="submit" value="I accept. Create my account"/>
                    </td>
                </tr>
            </table>
        </fieldset>

    </sf:form>
</div>