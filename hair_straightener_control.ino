int led = 13;

void setup() {
  pinMode(led, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available() > 0) {
    char command = Serial.read();

    if (command == '1') {
      digitalWrite(led, HIGH);      // POWER ON
      Serial.println("POWER ON");
    }
    else if (command == '2') {
      digitalWrite(led, LOW);       // POWER OFF
      Serial.println("POWER OFF");
    }
    else if (command == '3') {
      for (int i = 0; i < 5; i++) { // HEATING MODE
        digitalWrite(led, HIGH);
        delay(300);
        digitalWrite(led, LOW);
        delay(300);
      }
      Serial.println("HEATING MODE");
    }
    else if (command == '4') {
      digitalWrite(led, LOW);       // RESET
      Serial.println("RESET");
    }
    else {
      Serial.println("UNKNOWN COMMAND");
    }
  }
}
