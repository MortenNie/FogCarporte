<%--
  Created by IntelliJ IDEA.
  User: jakob
  Date: 5/22/2023
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
            Welcome to the image wall!
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>


        <p>Welcome to the image wall!
        Here are some pictures to give you inspiration.

            <small>Disclaimer: These carports are not built by us and might not contain our materials. They are purely for inspirational purposes.</small>
        </p>
        <br/>

        <div class="row">
            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <!-- column large 4, column medium 12, margin bottom 4
                 Skaber en box til at lægge billedet i, sådan så at de forbliver samme størrelse som alle de andre billeder.
                 mb-4/margin bottom er mellemrummet mellem billedet og billedet under. 4 er størrelsen på mellemrummet.
                -->
                <img
                        src="https://cdn.polhus.com/products/4499-carport-klas-1.jpg?ixlib=js-3.6.0&auto=compress%2Cformat&fit=crop"
                        class="w-100 shadow rounded mb-4"
                        alt="White double carport"
                />
                        <!-- w-100 = width-100, dvs. bredden fylder hele col'en.
                         Med andre ord, alle billederne har samme bredde.
                         -->

            </div>
            <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
                <img
                        src="https://renson-co-prd-kentico-website-live-cdnep.azureedge.net/getmedia/cc8065ba-9852-4567-be9d-5f036b51f995/carport.jpg"
                        class="w-100 h-100 shadow-sm rounded mb-4"
                        alt="Double carport with beautiful wooden shed"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
                <img
                        src="https://dihc.dk/wp-content/uploads/2021/05/Carport-Singuli-1.jpg"
                        class="w-100 h-100 shadow-sm rounded mb-4"
                        alt="Single & Double carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
                <img
                        src="https://www.quick-garden.co.uk/media/cache/sylius_shop_product_hero_webp/c/1/8/2/c1825df1fb3b5916d24fdae20edece43a4074311_AV038_5_carport_modern_double_6x6_img01.jpg"
                        class="w-100 h-100 shadow-sm rounded mb-4"
                        alt="Flat roof carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://www.carolinatimberworks.com/wp-content/uploads/2020/10/Timber-Frame-Carport.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Beautiful American Ranch/Farm style carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://pergolasofdistinction.com.au/wp-content/uploads/pod-timber-gallery-8-1613x1080.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Timber Carport Special Open-sided"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://www.quick-garden.co.uk/media/image/35/5d/0f05983802c0367bdfd98418ba92.jpeg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Cool Floaty Design Carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://alansfactoryoutlet.com/wp-content/uploads/2022/10/van-under-wooden-carport-with-metal-roof-1024x683.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Small simple Carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://www.airtasker.com/blog/wp-content/uploads/2023/05/carport-and-storage.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Carport with workshop garage shed"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
                <img
                        src="https://lorenwoodbuilders.com/wp-content/uploads/2020/08/Frietag4.jpg"
                        class="w-100 h-100 shadow-sm rounded mb-4"
                        alt="Carport with large seperated shed"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
                <img
                        src="https://www.crownpavilions.com/wp-content/uploads/2021/08/Sunrise-Car-Port-Hipped-Roof.jpg"
                        class="w-100 h-100 shadow-sm rounded mb-4"
                        alt="Pavilion Carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
                <img
                        src="https://images.squarespace-cdn.com/content/v1/5f2b0aed1706ae60a3af7abc/1608755607269-V98VSLO7OT77T25OYAI0/Leslie_4.png?format=2500w"
                        class="w-100 h-100 shadow-sm rounded mb-4"
                        alt="Modern Wooden Carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://i.pinimg.com/originals/0b/da/95/0bda95da493ac3c5576d3cebe3c9be94.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Aesthetic Wooden Design Carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://www.saqualityhomeimprovements.com.au/wp-content/uploads/dulwich-custom-wood-carport-adelaide.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Deep Multi-spaced Modern Carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://st.hzcdn.com/simgs/pictures/garages/grasshopper-studio-wittman-estes-landscape-img~5511c2e00535479d_8-4470-1-75852bc.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Modern Fenced Carport with Gate"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-4">
                <img
                        src="https://mrcarports.com.au/wp-content/uploads/2022/09/Carport-Garage-Extension.jpg"
                        class="w-100 h-100 shadow-sm rounded mb-4"
                        alt="Extension of House Carport"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://logcabins.co.uk/wp-content/uploads/2019/07/Classic-garage-7000-with-carport.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Indoor & Outdoor Carport & Garage"

                />
            </div>

            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                <img
                        src="https://kraftbuilding.com/wp-content/uploads/2014/06/IMG_5649_.jpg"
                        class="w-100 shadow-sm rounded mb-4"
                        alt="Suspicious-looking House extension Carport"

                />
            </div>



        </div>



    </jsp:body>
</t:pagetemplate>