<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="administrator.dashboard.form.label.totalNumberOfAnnouncement" path="totalNumberOfAnnouncement" />
	<acme:form-textbox code="administrator.dashboard.form.label.totalNumberOfCompanyRecords" path="totalNumberOfCompanyRecords" />
	<acme:form-textbox code="administrator.dashboard.form.label.totalNumberOfInvestorRecords" path="totalNumberOfInvestorRecords" />
	<acme:form-textbox code="administrator.dashboard.form.label.minimumOfRewardsRequests" path="minimumOfRewardsRequests" />
	<acme:form-textbox code="administrator.dashboard.form.label.maximumOfRewardsRequests" path="maximumOfRewardsRequests" />
	<acme:form-textbox code="administrator.dashboard.form.label.averageOfRewardsRequests" path="averageOfRewardsRequests" />
	<acme:form-textbox code="administrator.dashboard.form.label.standardDeviationOfRewardsRequests" path="standardDeviationOfRewardsRequests" />
	<acme:form-textbox code="administrator.dashboard.form.label.minimumOfRewardsOffers" path="minimumOfRewardsOffers" />
	<acme:form-textbox code="administrator.dashboard.form.label.maximumOfRewardsOffers" path="maximumOfRewardsOffers" />
	<acme:form-textbox code="administrator.dashboard.form.label.averageOfRewardsOffers" path="averageOfRewardsOffers" />
	<acme:form-textbox code="administrator.dashboard.form.label.standardDeviationOfRewardsOffers" path="standardDeviationOfRewardsOffers" />
</acme:form>

<h3>
<acme:message code="administrator.dashboard.form.label.firstChart"/>
</h3>

<canvas id="myChart" width="400" height="400"></canvas>
<script>

var data = {
	labels: [
		<jstl:forEach var="sector" items="${companiesPerSector}">
	    	"<jstl:out value="${sector[0]}"/>",
		</jstl:forEach>
	],
	datasets: [
		{
			data: [
				<jstl:forEach var="sector" items="${companiesPerSector}">
		    		"<jstl:out value="${sector[1]}"/>",
				</jstl:forEach>
			]
		}	
	]
};

var options = {
	scales: {
		yAxes: [
			{
				ticks: {
					suggestedMin: 0.0,
					suggestedMax: 10.0
				}
			}
		]
	},
	legend: {
		display: false
	}
};

var context = document.getElementById('myChart').getContext('2d');

new Chart(context, {
    type: 'bar',
    data: data,
    options: options
});
</script>

<h3><acme:message code="administrator.dashboard.form.label.secondChart"/></h3>

<canvas id="myChart2" width="400" height="400"></canvas>
<script>
var data = {
	labels: [
		<jstl:forEach var="sector" items="${investorsPerSector}">
	    	"<jstl:out value="${sector[0]}"/>",
		</jstl:forEach>
	],
	datasets: [
		{
			data: [
				<jstl:forEach var="sector" items="${investorsPerSector}">
		    		"<jstl:out value="${sector[1]}"/>",
				</jstl:forEach>
			]
		}	
	]
};

var options = {
	scales: {
		yAxes: [
			{
				ticks: {
					suggestedMin: 0.0,
					suggestedMax: 10.0
				}
			}
		]
	},
	legend: {
		display: false
	}
};

var context = document.getElementById('myChart2').getContext('2d');

new Chart(context, {
    type: 'bar',
    data: data,
    options: options
});
</script>
