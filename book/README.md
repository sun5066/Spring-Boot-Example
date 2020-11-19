# Spring-Boot thymeleaf view
* HTML, CSS, JS가 적용된 static web HTML 파일에 Controller 로 부터 전달되어 온 데이터를
기본 모양을 흐트러트리지 않는 범위에서 자유롭게 표현하는 View
* JSP 와 비교 했을때 JSP 는 서버를 거쳐서 Rendering 이 되지 않으면 어떻게 화면이 구성되는지 그 결과를 알기가 어렵다.
* 표준 Web browser 에서 open 을 했을때는 마치 static HTML 처럼 보여지고
서버에서 데이터가 전달되면 실제 데이터를 포함하여 rendering 한 후 보여지기 때문에
개발자와 디자이너가 협업하기에 매우 좋은 View 이다.

* Spring-Boot WAS 에서 거의 표준처럼 사용되는 view 이다.