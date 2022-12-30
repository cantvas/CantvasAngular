# Cantvas

> cant, v.: To use pretentious language, barbarous jargon, or
 technical terms; to talk with an affectation of learning.

 Cantvas is an ongoing project to create a new and simple learning management system (LMS). We identified some concerns with Canvas, an LMS we have been using for our course, and tried to implement some fixes for them. A few of these issues include:

 - UI: Canvas' UI is slow and not very responsive. Windowing is strange, with multiple scrollbars interfering with a smooth experience.
 - Performance: Even with a reasonable Internet connection, Canvas is _slow_.
 - Pages that are artifacts instead of tools: all three of us discussed our varying methods for interacting with Canvas and agreed that some pages offered us no practical value.

 # Project overview

 This is a web app with a client interface written in Angular. It exposes a simple UI that sends and receives data to and from a REST API written in Spring, with said data persisted in PostgreSQL. For now, all persistence happens in memory. Future work on the project will likely include moving the database into the cloud, as well as numerous other improvements.

 # Installation

 Clone this repo with `git clone https://github.com/cantvas/CantvasAngular.git`.

 You need an up-to-date JDK. We recommend the Temurin build available [here](https://adoptium.net/).

 As the client application runs in Angular, you must have `node` and the `Angular CLI` installed. You can find instructions to install these tools at `https://angular.io/guide/setup-local`.

 # Run it

 Once you have all the required tools, you can run the backend with `./mvnw spring-boot:run` in the root directory. From the `angularclient` directory, run the client app with `ng serve`, optionally specifying the `--open` flag to trigger a new browser window with the running app. 



Ben Lieberman
Mehtab Riar
Joe Rutkin
