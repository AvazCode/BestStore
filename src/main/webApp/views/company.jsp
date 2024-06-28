
<%@ page import="java.util.List" %>

<%@ page import="com.example.marketplace.dto.responseDTO.CompanyResDTO" %>
<%@ include file="header.jsp"%>
<%List<CompanyResDTO> organizationDTOList = (List<CompanyResDTO>) request.getAttribute("companies");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Tashkilot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Tashkilot ID</th>
                <th>Tashkilot nomi</th>
                <th>Tashkilot manzili</th>
                <th>Tashkilot tel raqami</th>
                <th>Tashkilot malumot</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (CompanyResDTO organizationDTO : organizationDTOList) {%>
            <tr>
                <td><%=organizationDTO.getId()%></td>
                <td><%=organizationDTO.getName()%></td>
                <td><%=organizationDTO.getAddress()%></td>
                <td><%=organizationDTO.getTell()%></td>
                <td><%=organizationDTO.getDescription()%></td>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=organizationDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=organizationDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=organizationDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Tashkilot o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/company/delete/<%=organizationDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=organizationDTO.getId()%>" aria-labelledby="exampleModalEditOrganization" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditOrganization"><b>Tashkilot o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/company/<%=organizationDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=organizationDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleOrganizationName" class="form-label">Tashkilot nomi</label>
                                        <input type="text" name="name" class="form-control" id="exampleOrganizationName" value="<%=organizationDTO.getName()%>" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleOrganizationAddress" class="form-label">Tashkilot manzili</label>
                                        <input type="text" name="address" class="form-control" id="exampleOrganizationAddress" value="<%=organizationDTO.getAddress()%>" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleOrganizationPhoneNumber" class="form-label">Tashkilot tel raqami</label>
                                        <input type="text" name="phoneNumber" class="form-control" id="exampleOrganizationPhoneNumber" value="<%=organizationDTO.getTell()%>" required>
                                    </div>

                                    <div class="mb-3">
                                        <label for="exampleOrganizationDescription" class="form-label">Tashkilot haqida malumot</label>
                                        <input type="text" name="description" class="form-control" id="exampleOrganizationDescription" value="<%=organizationDTO.getDescription()%>" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Bekor qilish</button>
                                        <button type="submit" class="btn btn-success">Saqlash</button>
                                    </div>
                                </div>
                            </form>

                    </div>
                    </div>
                </div>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
<%--Modal for insert--%>
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalOrganization2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalOrganization2"><b>Yangi tashkilot qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/market/company" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleOrganizationName2" class="form-label">Tashkilot nomi</label>
                        <input type="text" name="name" class="form-control" id="exampleOrganizationName2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganizationAddress2" class="form-label">Tashkilot manzili</label>
                        <input type="text" name="address" class="form-control" id="exampleOrganizationAddress2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganizationPhoneNumber2" class="form-label">Tashkilot tel raqami</label>
                        <input type="text" name="phoneNumber" class="form-control" id="exampleOrganizationPhoneNumber2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleOrganizationDescription2" class="form-label">Tashkilot haqida malumot</label>
                        <input type="text" name="description" class="form-control" id="exampleOrganizationDescription2" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Bekor qilish</button>
                        <button type="submit" class="btn btn-success">Saqlash</button>
                    </div>
                </div> </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>