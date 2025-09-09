# 🔦 Flash Blink App

An Android app built with **Java** that lets you blink the device’s flashlight a custom number of times. Enter a number, tap the button, and watch the torch flash accordingly.

---

## 📌 Overview

This project demonstrates how to control the camera flashlight programmatically using the **Camera2 API**. It leverages an input field for user interaction and a **Handler** to schedule blinking events with delays.

---

## 🚀 Features

* Control the device flashlight
* Enter a number to blink the flash that many times
* Uses Camera2 API for torch mode control
* Error handling for invalid or empty inputs
* Simple UI with **EditText** and **Button**

---

## 🗂️ Project Structure

```
📦 com.example.flash_blink
┣ 📄 MainActivity.java
┣ 🗂️ res/layout/activity_main.xml
┗ 🗂️ AndroidManifest.xml
```

---

## ⚙️ How It Works

1. User enters a number in the input field.
2. App validates the input (must be a positive integer).
3. A loop schedules torch ON/OFF events using a **Handler** with 500ms delay.
4. Flash blinks according to the entered number.

---

## 💻 Setup & Run

1. Clone the repo:

   ```bash
   git clone https://github.com/harinandanmv/blinking-flash.git
   ```
2. Open in **Android Studio**.
3. Ensure `CAMERA` and `FLASHLIGHT` permissions are declared in `AndroidManifest.xml`.
4. Connect an Android device with flash.
5. Run the app ▶️.

---

## ⚠️ Notes

* Works only on devices with a flashlight.
* Requires runtime camera permission if targeting Android M (6.0) and above.
* The blinking interval is currently fixed at **500ms**.

---

## 📚 References

* [Camera2 API](https://developer.android.com/reference/android/hardware/camera2/package-summary)
* [Android Handler](https://developer.android.com/reference/android/os/Handler)

---

✨ A fun and simple project to learn **camera hardware control** in Android!
