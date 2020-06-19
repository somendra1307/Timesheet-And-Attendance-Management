<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page='header.jsp' />
<jsp:include page='message.jsp' />
<div class="main-banner banner text-center">
    <div class="container">
        <h1>
            Buy / Sell <span class="segment-heading"> Agriculture Commodities Online </span> With Agritech
        </h1>
        <p>Search here for buying commodity in your area or post a free ad to sell</p>
        <a href="selectCategory?categoryType=Commodity">Post Selling Ad</a>
    </div>
</div>
<div class="content">
    <div class="categories">
        <div class="container">
            <span class="heading text">Search by a category to buy:</span><br>
            <select class="form-control searchBox" id="state">
                <option value="">Select State</option>
                <c:forEach var="state" items="${states}">
                    <option value="${state.value}">${state.value}</option>
                </c:forEach>
                <option value="All">All</option>
            </select> <br>
            <p class="center_Text">Or (If you want to search in specific
                area)</p>
            <br> <input type="text" class="searchBox"
                placeholder="Enter area pin code" name="pincode" id="pincode" /><br>
            <br>
            <div class="row">
                <c:forEach items="${resourceSpecifications}" var="item">
                    <div class="col-md-2">
                        <a href="#" class="submit_search submit" data-id='${item.id}'>
                            <div class="thumbnail">
                                <img src="${item.imageUrl}" />
                            </div>
                            <h4 class="clrchg" align="center">${item.displayName}</h4>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<jsp:include page='footer.jsp' />