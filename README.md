# FinanceHealth

**An Intelligent Financial Health Monitoring and Decision-Support Application for Small Businesses**

FinanceHealth is an Android application designed to help small business owners understand, monitor and improve their financial health. It provides financial insights, evaluates business performance and allows users to simulate different financial scenarios to make more informed business decisions.

## Key Features

### 1. User Authentication
- Google Sign-In authentication.
- Firebase Authentication integration.
- Secure user-specific access.

### 2. Business Profile Management
- Register and manage business information.
- Store business profile details.
- Associate business information with the authenticated user.

### 3. Financial Management
- Record business income and expenses.
- Track financial information.
- Monitor business financial performance.

### 4. Financial Health Assessment
- Evaluate the financial condition of a business.
- Analyze financial indicators.
- Generate insights to help business owners understand their financial position.

### 5. AI-Powered Financial Analysis
- Provide AI-assisted financial insights.
- Help interpret business financial information.
- Support informed financial decision-making.

### 6. Financial Stress Testing
Simulate potential financial challenges and understand their impact on business stability.

Available scenarios include:
- **Revenue Decline:** Simulates a reduction in business income.
- **Expense Surge:** Evaluates the impact of increased operating expenses.
- **Cash Depletion:** Examines how quickly available cash reserves may run out.
- **Emergency Shock:** Simulates unexpected financial expenses.

### 7. M-PESA Integration
- Safaricom Daraja API integration.
- Initiate payments using STK Push.
- Process payment callbacks.
- Check transaction status.

## Technology Stack

| Technology | Purpose |
|---|---|
| Kotlin | Android application development |
| Jetpack Compose | Modern Android user interface |
| Firebase Authentication | User authentication |
| Cloud Firestore | Business data storage |
| Firebase Cloud Functions | Backend functionality |
| AI API integration | AI-assisted financial analysis |
| Safaricom Daraja API | M-PESA payment integration |
| Gradle | Build automation |
| Git & GitHub | Version control |

## Project Structure

```text
FinanceHealth_IS/
│
├── app/
│   └── src/main/
│       ├── java/com/example/financehealth_is/
│       │   ├── ai/
│       │   ├── assessment/
│       │   ├── auth/
│       │   ├── business/
│       │   ├── dashboard/
│       │   ├── data/
│       │   ├── finances/
│       │   ├── mpesa/
│       │   ├── profile/
│       │   └── StressTest/
│       │
│       └── AndroidManifest.xml
│
├── functions/
│   └── src/
│       ├── ai/
│       └── index.ts
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Android Studio
- Android SDK
- JDK compatible with the project's Gradle configuration
- Git
- A Firebase project
- Safaricom Daraja developer credentials (for M-PESA integration)

### 1. Clone the Repository

```bash
git clone https://github.com/MaxwelKimtai/FinanceHealth_IS.git
```

### 2. Open the Project

Open the cloned `FinanceHealth_IS` directory in Android Studio and allow Gradle to synchronize.

### 3. Configure Firebase

1. Create or select a Firebase project.
2. Register the Android application using its application ID.
3. Download the Firebase `google-services.json` configuration file.
4. Place it inside the `app/` directory.
5. Enable the Firebase services required by the application, including Authentication and Cloud Firestore.

### 4. Configure API Credentials

Configure the required AI and Safaricom Daraja credentials using the appropriate secure configuration for the Android application and backend.

**Important:** Never commit private API secrets, service-account credentials or production payment credentials to GitHub.

### 5. Run the Application

Connect an Android device or start an emulator, then run the application through Android Studio.

## Backend Setup

The `functions/` directory contains Firebase Cloud Functions backend code.

To configure the backend:

1. Install Node.js and npm.
2. Install the Firebase CLI.
3. Navigate to the `functions/` directory.
4. Install the required dependencies.
5. Configure the required environment secrets.
6. Build and deploy the functions using the appropriate Firebase project configuration.

```bash
cd functions
npm install
npm run build
```

Deployment:

```bash
firebase deploy --only functions
```

*The available scripts and deployment configuration depend on the project's Firebase Functions setup.*

## Security Considerations

- Use Firebase Authentication to manage user identity.
- Apply appropriate Firestore Security Rules.
- Associate business records with authenticated user IDs.
- Keep API credentials and private keys out of source control.
- Validate payment callbacks and transaction results on the backend.

## Project Objective

FinanceHealth aims to make financial management more accessible to small business owners by combining financial tracking, intelligent analysis and scenario-based stress testing in one platform.

The application is intended to support better financial awareness, early identification of potential financial challenges and more informed business decisions.

## Contributors

Developed as an academic software development project.

## License

This project is currently intended for academic and demonstration purposes. Add an appropriate open-source license before permitting external reuse.
