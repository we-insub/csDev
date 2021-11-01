<!--인섭 코드-->

<%--
  Created by IntelliJ IDEA.
  User: kimchangsu
  Date: 2021. 8. 23.
  Time: 오후 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Navbar -->
    <jsp:include page="/WEB-INF/jsp/common/nav.jsp" />
    <!-- End of Navbar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <jsp:include page="/WEB-INF/jsp/common/topbar.jsp" />

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">회원가입 리스트 위인섭</h1>
                </div>

                <!-- 요기가 컨텐츠 -->

                <form:form action="/signup/signupListWis" method="get">
                <div class="form-row align-items-center">
                    <div class="col-auto">
                        <label class="sr-only" for=userId>userId</label>
                        <div class="input-group mb-2">
                            <div class="input-group-prepend">
                                <div class="input-group-text">검색조건</div>
                            </div>
                            <input type="text" class="form-control" id="userId" placeholder="ID" name="userId" value="${signupVOWis.userId}">
                        </div>
                    </div>
                    <div class="form-row align-items-center">
                        <div class="col-auto">
                            <label class="sr-only" for="nickname">nickname</label>
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">검색조건</div>
                                </div>
                                <input type="text" class="form-control" id="nickname" placeholder="닉네임" name="nickname" value="${signupVOWis.nickname}">
                            </div>
                        </div>
                        <div class="col-auto">
                            <button name="action" class="btn btn-info" type="submit">조회</button>
                            <button id="btnSave" name="btnSave" value="update" type="button" class="btn btn-success">수정</button>
                        </div>
                    </div>
                    </form:form>
                    <form:form id="updatelist" action="/signup/listUpdate" method="post">
                        <br /><br />
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th style="width: 2%;"><input name="checkall" id="checkall" type="checkbox"  /></th>
                                <th scope="col" style="width: 1%;">#</th>
                                <th scope="col" style="width: 10%;">ID</th>
                                <th scope="col" style="width: 10%;">비밀번호</th>
                                <th scope="col" style="width: 10%;">비밀번호 질문</th>
                                <th scope="col" style="width: 10%;">비밀번호 답변</th>
                                <th scope="col" style="width: 5%;">닉네임</th>
                                <th scope="col" style="width: 13%;">연락처</th>
                                <th scope="col" style="width: 10%;">성별</th>
                                <th scope="col" style="width: 10%;">주소1</th>
                                <th scope="col" style="width: 10%;">주소2</th>
                                <th scope="col" style="width: 5%;">개인정보 동의</th>
                                <th scope="col" style="width: 5%;">구매약관 동의</th>
                                <th scope="col" style="width: 5%;">판매약관 동의</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${signupListwis}" varStatus="status">
                                <tr>
                                    <td><input type="checkbox" class="list-check" name="check" id="check"  /></td>
                                    <td scope="row"><c:out value="${status.count}" /></td>
                                    <td>
                                        <input type="hidden" name="ListSignupVOWis[${status.index}].seq" value="${list.seq}"/>
                                        <input type="text" class="form-control" name="ListSignupVOWis[${status.index}].userId" value="${list.userId}"/></td>
                                    <td><input type="text" class="form-control" name="ListSignupVOWis[${status.index}].userPw" value="${list.userPw}"/></td>
                                    <td>
                                        <select class="form-control" name="ListSignupVOWis[${status.index}].pwQuestion">
                                            <c:forEach var="map" items="${signupPwAnswer}" varStatus="status2">
                                                <option value="${map.dtlCd}"<c:if test="${list.pwQuestion eq  map.dtlCd}" >selected="selected"</c:if>  >${map.dtlNm}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="text" class="form-control" name="ListSignupVOWis[${status.index}].pwAnswer" value="${list.pwAnswer}"/></td>
                                    <td><input type="text" class="form-control" name="ListSignupVOWis[${status.index}].nickname" value="${list.nickname}"/></td>
                                    <td>
                                        <select class="form-control" name="ListSignupVOWis[<c:out value="${status.index}" />].phoneNumber1">
                                            <c:forEach var="map" items="${signupPhone}" varStatus="status2">
                                                <option value="${map.dtlCd}" <c:if test="${list.phoneNumber1 eq map.dtlCd}">selected="selected"</c:if> >${map.dtlNm}</option>
                                            </c:forEach>
                                        </select>
                                        <input type="text" name="ListSignupVOWis[<c:out value="${status.index}" />].phoneNumber2" value="${list.phoneNumber2}" />
                                        <input type="text" name="ListSignupVOWis[<c:out value="${status.index}" />].phoneNumber3" value="${list.phoneNumber3}" />
                                    </td>
                                    <td>
<%--                                        <c:forEach var="map" items="${signupGender}" varStatus="status3">--%>
<%--                                            <input type="radio" id="gender${status.count}" value="${list.gender}" name="ListSignupVOWis[${status.index}].gender${list.seq }"--%>
<%--                                                   <c:if test="${list.gender eq map.dtlCd}">checked="checked"</c:if>>--%>
<%--                                            <label for="gender${status.count}" >${map.dtlNm }</label>--%>
<%--                                        </c:forEach>--%>

                                        <c:forEach var="gd"  items="${signupGender}"  varStatus="status3">
                                            <input  type="radio" id="gender${status3.index }" name="ListSignupVOWis[${status.index}].gender<%-- ${status.index } --%>" value="${gd.dtlCd }" <c:if test="${list.gender eq gd.dtlCd }">checked="checked"</c:if> >
                                            <label for="gender${status3.index }" >${gd.dtlNm }</label>
                                        </c:forEach>
                                    </td>
                                    <td><input type="text" class="form-control" name="ListSignupVOWis[${status.index}].address1" value="${list.address1}"/></td>
                                    <td><input type="text" class="form-control" name="ListSignupVOWis[${status.index}].address2" value="${list.address2}"/></td>
                                    <td>
                                        <input type="checkbox" name="ListSignupVOWis[${status.index}].termsInfoYn" value="Y" <c:if test="${list.termsInfoYn eq 'Y'}"> checked="checked"</c:if>>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="ListSignupVOWis[${status.index}].termsBuyYn" value="Y" <c:if test="${list.termsBuyYn eq 'Y'}"> checked="checked"</c:if>>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="ListSignupVOWis[${status.index}].termsSellYn" value="Y" <c:if test="${list.termsSellYn eq 'Y'}"> checked="checked"</c:if>>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!-- 요기가 컨텐츠 끝 -->
                    </form:form>
                </div>
            </div>
            <!-- Footer -->
            <%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
            <!-- End of Footer -->
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->


</body>
</html>
<script>

    // 아래코드는 체크올이 체크되었을때 아래체크박스가 모두 체크되게 하기 혹은 체크해제
    $(document).ready(function(){


        // 수정 버튼 눌렀을 떄
        $('#btnSave').click(function(){
            //alert("안녕");
            $('#updatelist').submit();
        });
        // $('#btnSave').click(function (){
        //     $('#updatelist').submit;
        //     // alert("test");
        // });

        $("#checkall").change(function(){
            if($("#checkall").is(":checked",true)){
                $("input:checkbox[name='check']").prop("checked", true);
            }
            else{
                $("input:checkbox[name='check']").prop("checked", false);
            }
        });
    });


    // function saveSample(){
    //     $('#action').val('save');
    //     // $('#btnDelete').hide();
    //     fn_callAjax('/saveAsyncSample', $('#frmSave').serialize(), 'POST', cb_saveSample);
    // }
    //
    // function cb_saveSample( rstData ){
    //     selectSampleList();
    //     fn_formReset('frmSave');
    //     alert('저장완료');
    // }

    // 아레코드는 체크박스 클래스를 불러와서 변수 a에 담고, 체크박스 모두 뽑아서 체크가 모두 되면 체크올 체크 혹은 해제
    $("input[type='checkbox'].list-check").change(function(){
        var a = $("input[type='checkbox'].list-check");
        if(a.length == a.filter(":checked").length){
            $("input:checkbox[name='checkall']").prop("checked", true);
        }
        else{
            $("input:checkbox[name='checkall']").prop("checked", false);
        }
    });

    // //상위 체크박스 (체크올) 을 클릭할시에 로우에있는 체크박스들 체크되게 하기
    // $('#checkall').click(function () {
    //     if ($("input:checkbox[name='checkall']").prop("checked")) {
    //         $("input:checkbox[name='check']").prop("checked", true);
    //     } else {
    //         $("input:checkbox[name='check']").prop("checked", false);
    //     }
    // });


</script>


