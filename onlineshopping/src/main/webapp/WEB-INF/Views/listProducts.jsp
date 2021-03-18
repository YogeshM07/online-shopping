<div class="container">



	<div class="col-md-3">

		<%@include file="./shared/sidebar.jsp"%>

	</div>

	<!--  to disply actule p -->
	<div class="col-md-9">

		<div class="row">
			<div class="col-lg-12">

				<c:if test="${userClickAllproducts==true}">
					<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Product</li>

					</ol>
				</c:if>				


				<c:if test="${userClickcategoryproducts==true}">
					<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">/Category/</li>
						<li class="active">${category.name}</li>

					</ol>
				</c:if>


			</div>

		</div>


	</div>

</div>