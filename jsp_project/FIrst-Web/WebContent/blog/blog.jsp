<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Blog</title>
    
    <!-- http://localhost:8080/FIrst-Web/blog/css/myblog.css -->
    
    <link rel="stylesheet" href="/FIrst-Web/blog/css/myblog.css">
</head>
<body>

    <div id="main_wrap">

        <!-- header 시작 -->
		<%@ include file="frame/header.jsp" %>
        <!-- header 끝-->

        <!-- navigation 시작 -->
		<%@ include file="frame/nav.jsp" %>
        <!-- navigation 끝 -->

        <!-- 컨테츠 영역 시작-->
        <div id="content_wrap">
            <section>
                <article class="border_bottom_a margin_bottom_20">
                    <h1 class="title">[넘버스]넷제로 20년 앞당긴 SK이노베이션의 '현실적 고민'들</h1>
                    <p class="date">2021.07.02.</p>
                    <img class="post_img" src="../images/post01.jpg">
                    <p class="postcontent">전 세계가 '이산화탄소와 전쟁' 중입니다. 이산화탄소와 아산화질소 등 온실가스(GHGs)의 농도가 증가하면서 온실효과가 발생해 지구 온난화가 발생하고 있죠.

                        경영계에 따르면 인류에게 주어진 온도는 '섭씨 2도'입니다. 지구 평균 지표기온이 섭씨 2도 이상 상승한다면 빙상과 빙모가 녹아 해수면이 1m 이상 상승한다고 합니다. 이로 인한 이상기온 등으로 생존에 위협을 받게 된다고 합니다. 18세기 산업혁명부터 무분별하게 화석연료를 사용해 이산화탄소를 방출한 결과죠. 지금처럼 화석연료를 쓴다면 인류의 생존을 보장할 수 없죠.
                        
                        기업도 인류와 함께 사라질 것으로 보입니다. 인류가 생존할 수 없는 곳에서 기업이 어떻게 영속할 수 있을까요.
                        
                        2020년대 기업들도 지속가능한 생존과 번영을 위해 친환경과 ESG(환경, 사회, 지배구조)에 대한 고민을 시작했습니다.</p>
                </article>
                <article class="border_bottom_a margin_bottom_20">
                    <h1 class="title">[넘버스]넷제로 20년 앞당긴 SK이노베이션의 '현실적 고민'들</h1>
                    <p class="date">2021.07.02.</p>
                    <img class="post_img" src="../images/post01.jpg">
                    <p class="postcontent">전 세계가 '이산화탄소와 전쟁' 중입니다. 이산화탄소와 아산화질소 등 온실가스(GHGs)의 농도가 증가하면서 온실효과가 발생해 지구 온난화가 발생하고 있죠.

                        경영계에 따르면 인류에게 주어진 온도는 '섭씨 2도'입니다. 지구 평균 지표기온이 섭씨 2도 이상 상승한다면 빙상과 빙모가 녹아 해수면이 1m 이상 상승한다고 합니다. 이로 인한 이상기온 등으로 생존에 위협을 받게 된다고 합니다. 18세기 산업혁명부터 무분별하게 화석연료를 사용해 이산화탄소를 방출한 결과죠. 지금처럼 화석연료를 쓴다면 인류의 생존을 보장할 수 없죠.
                        
                        기업도 인류와 함께 사라질 것으로 보입니다. 인류가 생존할 수 없는 곳에서 기업이 어떻게 영속할 수 있을까요.
                        
                        2020년대 기업들도 지속가능한 생존과 번영을 위해 친환경과 ESG(환경, 사회, 지배구조)에 대한 고민을 시작했습니다.</p>
                </article>
            </section>

			<!-- aside 시작 -->
			<%@ include file="frame/aside.jsp" %>
			<!-- aside 종료 -->

        </div>
        <!-- 컨테츠 영역 끝-->

        <!--footer 시작 -->
		<%@ include file="frame/footer.jsp" %>
        <!--footer 끝 -->

    </div>
    
</body>
</html>