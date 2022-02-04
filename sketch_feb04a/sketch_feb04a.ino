int incomingByte = 0;
void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
//Serial.write("Hello");
//    delay(1000);
  if(Serial.available() > 0){
    
    incomingByte = Serial.read();
    Serial.write(incomingByte);
    if(incomingByte == 1){
      digitalWrite(13, HIGH);
    }
    else if(incomingByte == 0){
      digitalWrite(13, LOW);  
    }
     
    }
}
