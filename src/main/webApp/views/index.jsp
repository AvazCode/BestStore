<%@ include file="header.jsp"%>

<div class="row">
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/delivery" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h1 class="mt-1 mb-3">Delivery</h1>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-truck"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/settings" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h1 class="mt-1 mb-3">Shopify</h1>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-shop"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/store" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h1 class="mt-1 mb-3">Store</h1>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-store"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/return" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h1 class="mt-1 mb-3">Return</h1>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-rotate-left"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/sell" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h1 class="mt-1 mb-3">Sell</h1>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-cart-shopping"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
    <div class="col-md-4">
        <a href="<%=request.getContextPath()%>/market/warehouse" class="link-light">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col mt-0">
                            <h1 class="mt-1 mb-3">Warehouse</h1>
                        </div>
                        <div class="col-auto">
                            <div class="stat text-primary">
                                <i class="fa-solid fa-warehouse"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </div>
</div>

<%@ include file="footer.jsp"%>