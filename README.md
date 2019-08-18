Example of Selenium/Serenity project.


Lesson 1
Testing Web Applications with Serenity. Serenity BDD. Serenity structure
links:
https://serenity-bdd.github.io/theserenitybook/latest/web-testing-in-serenity.html
https://serenity-bdd.github.io/theserenitybook/latest/page-objects.html

Serenity wrapper требует соблюдения правил структуры проекта, иначе не будет формироватся отчет
Serenity, так в проекте нам нужно использовать прослойку Steps для обработки методов классов Page.

Переинициализация клонированого проэкта с Git
Сначала нужно удалить папку git с записями истории в директории проекта (она default disabled)
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git init
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git remote add origin https://github.com/omkhrystenko/serenitySelenium.git
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git add --all
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git status
C:\Users\Dell\IdeaProjects\serenity-selenium-22.07.19>git commit -m "initial commit"

Подвязка проэкта под IDE
Нужно переинициализировать структуру залитого проекта и подключить модули, для этого
File -> Project structure -> Modules -> Проставить разметку на папки (напр. java - Test, test.java.resourсes - Test Resourсes,
main - Sources и т.д.


Home Task #1:
Implement successfulLoginTest()
- Explore documentation for Serenity PageObject and use it to implement test scenario
- Add .gitignore and README.md to your project and share it on GitHub


Lesson 2
Using cloud web and mobile testing platforms for remote test launching (f.e. BrowserStack, SauceLabs)
1)Для запуска тестов на платформе в облаке нам нужно сначала создать свой акаунт. Так как эти платформы
платные то создаем Trial вариант.
2)Заходим в свой профайл выбираем Summary - сдесь мы видим сколько времени у нас осталось для бесплатного
запуска тестов на этом аккаунте
3)В профайле открываем закладку Settings - сдесь мы можем взять ключи "Username" и "Access Key" их
потом нужно прописать в properties RemoteDriver или передать через командную строку во время запуска тестов
(разделитель - ":").
Пример:
a) С агрегацией отчета Serenity (test может не работать поэтому мы использовали verify):
mvn clean test serenity:aggregate
-Dmaven.clean.failOnError=false
-Dmaven.test.failure.ignore=true
-Dwebdriver.remote.url=https://olehxxxxxxxxxnko1:ruMfFmLKxRh6hj78A6HH@hub-cloud.browserstack.com/wd/hub
-Dwebdriver.remote.driver=chrome
-Dwebdriver.remote.os=WINDOWS
-Dwebdriver.remote.os_version=10
-Dwebdriver.remote.browserstack.debug=true
-Dchrome.switches="--no-sandbox,--ignore-certificate-errors,--homepage=about:blank,--no-first-run"

b) Без агрегации отчета Serenity
mvn clean verify
-Dwebdriver.remote.url=http://kjhghgtau1:uyiyizD67oGnPsU6RsK9N@hub-cloud.browserstack.com/wd/hub
-Dwebdriver.remote.os="WINDOWS"
-Dwebdriver.remote.os_version="10"
-Dwebdriver.remote.driver=Chrome

Собрать отчет Serenity мы можем если у нас к проекту помимо плагинов Serenity подключен плагин
"maven-surefire-plugin". Отчет генерится из папки target -> site -> serenity -> index.html.

Home Task #2
1. Complete successfulLoginTest() using serenity approach
- use structure that we initiated during the lesson
- feel free to read Serenity documentation for more examples
2. Make sure your test is running on BrowserStack
- also make sure Serenity report is generated


Lesson 3
Serenity BDD. Gherkin language in serenity.

links:
http://thucydides.info/docs/serenity-staging/

Для подключения BDD Serenity в pom файл нужно прописать dependency "net.serenity-bdd.serenity-jbehave".

Serenity BDD проект строится на базе gherkin language (GIVEN - WHEN - THEN). Для описания функционала
тест кейса в директории src -> test -> resources (для подвязки к папке test, правый клик на resources ->
Mark Directory as -> Test Resources Root) создаем пакет "story", а в нем файл "login" с разрешением
".story", Intelij предложит нам установить плагин для чтения файлов с таким разрешением из перечня
плагинов выбираем плагин Khumar. Синтаксис файла login.story должен подсвечиватся плагином.

Home Task #3:
- Install Doker for Windows
- Make sure you have privileges to run selenoid binaries

https://medium.com/@Volirik/%D0%BA%D0%B0%D0%BA-%D1%83%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%82%D1%8C-%D0%B8-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-docker-%D0%BD%D0%B0-windows-1f430c82732e


Lesson 4
Docker. Selenoid.

links:
https://aerokube.com/selenoid/latest/
https://johnfergusonsmart.com/running-individual-scenarios-jbehave-cucumber-serenity-bdd/
https://github.com/aerokube/cm/releases/tag/1.6.0
https://aerokube.com/cm/latest/

Selenoid is a kind of Selenium Hub (separate utility for selenium that allows you to work remotely).
(F.e. Selenium hub is installed on separate server with linux and gives us its URL and port, and using
this data in driver properties on our computer we can run tests on selenium hub server from our computer
with Windows). Selenium hub gives us opportunity to divide code and browsers to separate computers.

Docker allows you to implement different OS virtual machines on the server where selenium hub was installed.
G.G.R. (kind of Selenoid for launching on CMD project)

- Установка Docker на Windows происходила через файл DockerToolbox.exe скачанный по ссылке которую прислали в Home Task #3

- Установка Selenoid:
We use manual for install on link https://aerokube.com/selenoid/latest/ there we need to load binary
files first: Configuration Manager (link https://github.com/aerokube/cm/releases/tag/1.6.0) for Selenoid
file cm_windows_amd64.exe

a)Меняем имя скачанного файла на cm.exe и запускаем в командной строке:
> ./cm.exe selenoid start --vnc (в виндовс cm.exe selenoid start --vnc) после установки докера в ЦМД запустили скачаный эксешник через эту команду
Началось подкачивание образов доккера. Это конфигур. менеджер который 1) проверяет есть ли доккер, 2)достает образ селеноида,
3)Достает образы операционных систем и браузеров (в этих образах наодится ОС Убунту и версии браузеров)
Эти образы подключаются к докеру и через докер могут взаимодействовать с селеноидом и через него с нашим кодом
cm.exe это мы переименовали скачанный файл cm_windows_amd64.exe

b)Скачиваем интерфейс для Selenoid
$ ./cm selenoid-ui start   выкачивает образы которые имеют удобный интерфейс
cm это мы переименовали скачанный файл cm_windows_amd64.exe (запускаем через коммандную строку)
Интерфейс запускается в браузере на http://localhost:8080/#/;
Команда для запуска:
docker run -d --name selenoid-ui -p 8080:8080 aerokube/selenoid-ui --selenoid-uri http://${SELENOID_HOST}:4444

В коде нужно отобразить соответствующие property и driver:

DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setBrowserName("chrome");
capabilities.setVersion("76.0");
capabilities.setCapability("enableVNC", true);
capabilities.setCapability("enableVideo", false);

RemoteWebDriver driver = new RemoteWebDriver(
    URI.create("http://localhost:4444/wd/hub").toURL(),
    capabilities
);

Home Task #4:
Run created BDD feature for Login
- Make sure proper Jbehave plugin installed in IDEA
- Follow this article to complete home Task: https://johnfergusonsmart.com/running-individual-scenarios-jbehave-cucumber-serenity-bdd/