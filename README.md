# 💧 Water Tank Monitoring System  
> *A Live Java Swing Project Demonstrating the Observer Design Pattern*  

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![Pattern](https://img.shields.io/badge/Observer%20Pattern-✓-green?style=for-the-badge)

---

## 🧠 Overview  
The **Water Tank Monitoring System** is an interactive **Java Swing application** built using the **Observer Design Pattern**.  
It simulates how multiple systems (Display, Alarm, SMS, and Splitter) respond dynamically to water level changes in real time.

---

## 🚀 Features  

🌊 **Real-Time Updates:** Move the vertical slider to change water levels and watch all observer windows react instantly.  
📊 **Modular GUI Frames:**  
- 📺 **Display Frame:** Shows current water level.  
- 🔔 **Alarm Frame:** Turns **On** when water ≥ 75%.  
- ⚙️ **Splitter Frame:** Turns **On** when water ≥ 90%.  
- 📱 **SMS Frame:** Displays *“SMS Sending : level”*.  
🎨 **User-Friendly Interface:** Clean Swing layout with customizable colors & fonts.

---

## 🖼️ UI Preview (Concept Sketch)
```
 ┌────────────────────────────┐
 │        Water Tank          │
 │      (Vertical Slider)     │
 │                            │
 │   [||||||||||||||]  75%    │
 └────────────────────────────┘

 ┌──────────────────────┐   ┌──────────────────────┐
 │     Display Frame    │   │     Alarm Frame      │
 │         75           │   │         On           │
 └──────────────────────┘   └──────────────────────┘

 ┌──────────────────────┐   ┌──────────────────────┐
 │       SMS Frame      │   │    Splitter Frame    │
 │  SMS Sending : 75    │   │         Off          │
 └──────────────────────┘   └──────────────────────┘
```

---

## ⚙️ Architecture — Observer Pattern

| Role | Class | Description |
|------|--------|-------------|
| **Subject** | `WaterTankController` | Maintains water level and notifies observers |
| **Observer** | `WaterLevelObserver` | Abstract base for all frames |
| **Concrete Observers** | `DisplayFrame`, `AlarmFrame`, `SplitterFrame`, `SMSFrame` | Each reacts differently when updated |
| **Trigger UI** | `WaterTankFrame` | Contains the slider that sets the water level |

---

## 🧩 How It Works

1. Adjust the slider in **WaterTankFrame** 🎚️  
2. The controller updates the water level.  
3. All observer windows’ `update()` methods fire automatically.  
4. Each frame updates its UI instantly (Alarm → ON, Display → Number, etc.).  

---

## 🖥️ Tech Stack  
- 💻 **Java (JDK 8+)**  
- 🪟 **Swing (GUI Framework)**  
- 🧩 **Observer Design Pattern**

---

## 🧰 Setup & Run  

```bash
# Step 1: Compile
javac WaterTank.java

# Step 2: Run
java WaterTank
```

All windows (Water Tank + 4 observers) will open automatically.  
Move the slider up/down to see the dynamic reactions. ⚡

---

## 🎨 Optional UI Enhancements

Add colors & icons for more visual feedback:
```java
alarmLabel.setForeground(Color.RED);
splitterLabel.setForeground(Color.BLUE);
smsLabel.setForeground(Color.MAGENTA);
displayLabel.setForeground(Color.GREEN);
```

You can also add:
- Gradient backgrounds 🎨  
- Icons for each frame 🖼️  
- Sound effects for Alarm 🔔  

---

## 🗂️ Project Structure
```
📦 WaterTankProject
 ┣ 📄 WaterTank.java
 ┣ 📄 WaterTankController.java
 ┣ 📄 WaterTankFrame.java
 ┣ 📄 WaterLevelObserver.java
 ┣ 📄 DisplayFrame.java
 ┣ 📄 AlarmFrame.java
 ┣ 📄 SplitterFrame.java
 ┗ 📄 SMSFrame.java
```

---

## 📊 Output Example

| Water Level | Display | Alarm | Splitter | SMS Message |
|--------------|----------|--------|-----------|--------------|
| 50 | 50 | Off | Off | SMS Sending : 50 |
| 75 | 75 | On | Off | SMS Sending : 75 |
| 90 | 90 | On | On | SMS Sending : 90 |

---

## 💡 Learning Outcomes  
- Understand how the **Observer Pattern** enables modular event-driven updates.  
- Learn Swing layout management & event handling (`ChangeListener`).  
- Build multiple synchronized GUI components in Java.

---

## 🏁 Result  
A **fun, interactive, and pattern-driven** Java application 💧  
demonstrating real-time event synchronization across multiple UI components.