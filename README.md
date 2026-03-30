# Smart Hair Straightener Control System

## 📌 Description
This project is a smart hair straightener control system developed using Java Swing GUI and Arduino. The system allows users to control the device through a graphical interface and receive real-time feedback via serial communication.

---

## 🛠 Technologies Used
- Java (Swing GUI)
- Arduino
- Serial Communication (USB / COM Port)

---

## ⚙️ Features
- Power ON → Device turns ON (LED ON)
- Power OFF → Device turns OFF (LED OFF)
- Heating Mode → LED blinks
- Reset → System resets (LED OFF)
- Real-time status feedback displayed in GUI

---

## 🔌 Hardware Setup
- Arduino Uno
- LED
- Resistor (220Ω)
- USB Cable

---

## 📤 How to Upload Arduino Code
1. Open Arduino IDE  
2. Select the correct board (Arduino Uno)  
3. Select the correct COM port  
4. Upload the `.ino` file  

---

## ▶️ How to Run
1. Connect Arduino to the computer via USB  
2. Upload the Arduino code  
3. Close Arduino IDE  
4. Run the Java application  
5. Select the correct COM port  
6. Use GUI buttons to control the system  

---

## 🔄 Communication Protocol

### Commands (Java → Arduino)
- "1" → POWER ON  
- "2" → POWER OFF  
- "3" → HEATING MODE  
- "4" → RESET  

### Responses (Arduino → Java)
- "POWER ON"  
- "POWER OFF"  
- "HEATING MODE"  
- "RESET"  

---

## 🖥 GUI Screenshot

![GUI](hairstraightener_gui_screenshot.jpeg)

---

## 🎯 Purpose
This project demonstrates a smart hair straightener control system where a Java GUI communicates with an Arduino via serial communication. It allows users to control the device (power and heating) and receive real-time status feedback.
