<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/all.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/app.css" rel="stylesheet">
    <title>Market</title>
</head>

<body>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="index.html">
                <span class="align-middle">Market</span>
            </a>
            <ul class="sidebar-nav">
                <li class="sidebar-header">
                    Pages
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/main">
                        <i class="fa-solid fa-house mx-sm-1"></i> <span class="align-middle">Menu</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/delivery">
                        <i class="fa-solid fa-truck mx-sm-1"></i> <span class="align-middle">Delivery</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/settings">
                        <i class="fa-solid fa-shop mx-sm-1"></i> <span class="align-middle">Shopify</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/store">
                        <i class="fa-solid fa-store mx-sm-1"></i> <span class="align-middle">Store</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/return">
                        <i class="fa-solid fa-rotate-left mx-sm-1"></i> <span class="align-middle">Return</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/sell">
                        <i class="fa-solid fa-cart-shopping mx-sm-1"></i> <span class="align-middle">Sell</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/warehouse">
                        <i class="fa-solid fa-warehouse mx-sm-1"></i> <span class="align-middle">Return Warehouse</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="main">
        <nav class="navbar navbar-expand navbar-light navbar-bg">
            <a class="sidebar-toggle js-sidebar-toggle">
                <i class="hamburger align-self-center"></i>
            </a>
        </nav>

        <main class="content">
            <div class="container-fluid">