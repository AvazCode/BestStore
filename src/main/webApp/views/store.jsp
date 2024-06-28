<%@ include file="header.jsp"%>

<div class="row">
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/storeproduct" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h5 class="card-title">Store Product</h5>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-building"></i>
                            </div>
                        </div>
                    </div>
                    <h1 class="mt-1 mb-3">23.46</h1>
                    <div class="mb-0">
                        <span class="text-muted">Store Product soni: 5 ta</span>
                    </div>
                </div>
            </div>
        </a>
    </div>


    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/storedoc" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h5 class="card-title">Store Documents</h5>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-cart-shopping"></i>
                            </div>
                        </div>
                    </div>
                    <h1 class="mt-1 mb-3">14.212</h1>
                    <div class="mb-0">
                        <span class="text-muted">Store Document soni: 4 ta</span>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/storedocitem" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h5 class="card-title">Store Document Items</h5>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-file"></i>
                            </div>
                        </div>
                    </div>
                    <h1 class="mt-1 mb-3">14.212</h1>
                    <div class="mb-0">
                        <span class="text-muted">Store Document Items: 4 ta</span>
                    </div>
                </div>
            </div>
        </a>
    </div>
</div>

<%@ include file="footer.jsp"%>