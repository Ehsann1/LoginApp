# Login Android Application

This is a simple Android application that demonstrates a basic login system. The application has two activities:
1. **MainActivity**: The login page where the user enters their credentials.
2. **DashboardActivity**: The dashboard that the user is redirected to upon successful login.

---

## Features
- **User Authentication**: Checks username and password against predefined credentials.
- **Error Handling**: Displays appropriate error messages for incorrect or empty fields.
- **Activity Navigation**: Redirects the user to a new activity upon successful login.

---

## Technologies Used
- **Java**: The programming language used for the application.
- **Android SDK**: For building the app.
- **Android Studio**: IDE for development.
- **Toast**: Used for showing messages to the user.

---

## Predefined Credentials
- **Username**: `Ehsan`
- **Password**: `1234`

---

## Application Flow

1. The user enters their username and password in the login form.
2. The app performs the following checks:
   - If either field is empty, a message (`تمامی فیلد ها الزامیست`) is shown.
   - If the username and password match the predefined credentials:
     - A success message (`با موفقیت وارد شدید :)`) is displayed.
     - The user is redirected to the `DashboardActivity`.
   - If the username is correct but the password is incorrect, a message (`رمزعبور اشتباه است!`) is displayed.
   - If the password is correct but the username is incorrect, a message (`نام کاربری اشتباه است!`) is displayed.
   - If both are incorrect, a message (`نام کاربری و رمزعبور اشتباه است!`) is displayed.

---

## File Structure
### Java Files
1. **`MainActivity.java`**
   - Handles the login functionality.
   - Contains logic for authentication and error handling.

2. **`DashboardActivity.java`**
   - Displays a welcome screen upon successful login.

### XML Layout Files
1. **`activity_main.xml`**
   - Layout for the login screen with input fields and a login button.

2. **`activity_dashboard.xml`**
   - Layout for the dashboard screen, welcoming the user.

---

## How to Run
1. Clone or download the project to your local machine.
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.
4. Enter the credentials (`Ehsan` / `1234`) to access the dashboard.

---

## Future Improvements
- Add password encryption for enhanced security.
- Connect to a database or API for dynamic user authentication.
- Implement a "Forgot Password" feature.
- Enhance UI design with modern components.

---

## License

This project is licensed under the **MIT License**. See the `LICENSE` file for details. 
