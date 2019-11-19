<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/" />
			<acme:menu-suboption code="master.menu.anonymous.announcement" action="/anonymous/announcement/list" />
			<acme:menu-suboption code="master.menu.anonymous.company-record" action="/anonymous/company-record/list" />
			<acme:menu-suboption code="master.menu.anonymous.top-company-record" action="/anonymous/company-record/list_top" />
			<acme:menu-suboption code="master.menu.anonymous.investorRecord" action="/anonymous/investor-record/list" />
			<acme:menu-suboption code="master.menu.anonymous.top-investor-record" action="/anonymous/investor-record/list_top" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list" />
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show" />
			<acme:menu-suboption code="master.menu.administrator.spam-words" action="/administrator/spam-word/list" />
			<acme:menu-suboption code="master.menu.administrator.announcements" action="/administrator/announcement/list" />
      		<acme:menu-suboption code="master.menu.administrator.announcements.create" action="/administrator/announcement/create"/>
      		<acme:menu-suboption code="master.menu.administrator.challenge" action="/administrator/challenge/list" />
      		<acme:menu-suboption code="master.menu.administrator.challenge.create" action="/administrator/challenge/create" />
			<acme:menu-suboption code="master.menu.administrator.company_records" action="/administrator/company-record/list" />
      		<acme:menu-suboption code="master.menu.administrator.company_records.create" action="/administrator/company-record/create"/>
      		<acme:menu-suboption code="master.menu.administrator.investor_records" action="/administrator/investor-record/list" />
      		<acme:menu-suboption code="master.menu.administrator.investor_records.create" action="/administrator/investor-record/create"/>
      		<acme:menu-suboption code="master.menu.administrator.banners.commercial-banner" action="/administrator/commercial-banner/list" />
			<acme:menu-suboption code="master.menu.administrator.banners.commercial-banner.create" action="/administrator/commercial-banner/create" />
			<acme:menu-suboption code="master.menu.administrator.banners.non-commercial-banner" action="/administrator/non-commercial-banner/list" />
			<acme:menu-suboption code="master.menu.administrator.banners.non-commercial-banner.create" action="/administrator/non-commercial-banner/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.announcement" action="/authenticated/announcement/list" />
			<acme:menu-suboption code="master.menu.authenticated.request" action="/authenticated/request/list" />
			<acme:menu-suboption code="master.menu.authenticated.investor-record" action="/authenticated/investor-record/list" />
			<acme:menu-suboption code="master.menu.authenticated.offer" action="/authenticated/offer/list" />
			<acme:menu-suboption code="master.menu.authenticated.challenge" action="/authenticated/challenge/list" />
			<acme:menu-suboption code="master.menu.authenticated.company-record" action="/authenticated/company-record/list" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.request.create" action="/provider/request/create"/>
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.offer.create" action="/consumer/offer/create"/>
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/" />
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update"
				access="hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update"
				access="hasRole('Consumer')" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>
