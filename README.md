This project simulates/mimics a scoring device in a bowling lane. 

# How to run
From terminal, run ```mvn spring-boot:run```

On a web browser, go to http://localhost:8080. The rest should be self explanatory. 

# Assumptions

Clicking on "Next Play" hyperlink, randomly generates an acceptable number in the game of bowling. 
In the real game, a player may roll the ball once/twice/thrice depending on the frame and the scores that 
he/she makes in prior rolls.

# Known Issues

Within a frame, when a strike/spare is scored, the Score attribute would temporarily show up as "0". 
Please interpret 0 as undetermined/blank which will eventually be corrected by the next one/two subsequent rolls.   

# To run tests
From terminal, run ```mvn clean install```