# API Testing Project

This project contains automated API tests for the FakerAPI companies endpoint using REST Assured, TestNG, and JSON
Schema validation.

## Project Overview

The project tests the `https://fakerapi.it/api/v1/companies` endpoint with two main test suites:

1. **APISchemaVerificationTest** - Validates API response against JSON schema
2. **APITest** - Tests different quantity parameters and response validation

## Prerequisites

### Required Tools & Applications

1. **Java Development Kit (JDK)**
    - Version: 8 or higher (recommended: JDK 11+)
    - Download from: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)

2. **IntelliJ IDEA**
    - Version: Community or Ultimate edition
    - Download from: [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

3. **Gradle** (included in project)
    - The project uses Gradle Wrapper, so no separate Gradle installation is required
    - Gradle version is managed through `gradle/wrapper/gradle-wrapper.properties`

### Dependencies

The project uses the following main dependencies (managed via `build.gradle`):

- **REST Assured**: 5.3.0 - For API testing
- **JSON Schema Validator**: 4.3.3 - For schema validation
- **TestNG**: 7.7.0 - For test framework
- **JUnit Jupiter**: 5.10.0 - For additional testing capabilities
- **Hamcrest**: For assertions and matchers

## Project Structure

```
├── build.gradle                 # Gradle build configuration
├── src/
│   └── test/
│       ├── java/
│       │   └── tests/
│       │       ├── APISchemaVerificationTest.java  # Schema validation tests
│       │       └── APITest.java                    # API parameter tests
│       └── resources/
│           └── jsonschema.json                     # JSON schema definition
└── build/                      # Build output directory
```

## Test Files Description

### 1. APISchemaVerificationTest.java

- **Purpose**: Validates API response structure against predefined JSON schema
- **Endpoint**: `https://fakerapi.it/api/v1/companies`
- **Validations**:
    - HTTP status code 200
    - Response matches JSON schema (`jsonschema.json`)
    - All company IDs are not null
    - Response structure validation

### 2. APITest.java

- **Purpose**: Tests different quantity parameters and response validation
- **Endpoint**: `https://fakerapi.it/api/v1/companies?_quantity={quantity}`
- **Test Cases**:
    - `testTwentyData()`: Tests with quantity=20
    - `testFiveData()`: Tests with quantity=5
    - `testOneData()`: Tests with quantity=1
- **Validations**:
    - HTTP status code 200
    - Total count matches requested quantity
    - Data array size matches requested quantity

### 3. jsonschema.json

- **Purpose**: Defines the expected structure of the API response
- **Schema**: JSON Schema
- **Validates**: Company data structure including nested objects (addresses, contact information)

## Setup Instructions

### Step 1: Clone the Project

```bash
git clone <repository-url>
```

### Step 2: Open in IntelliJ IDEA

1. Open IntelliJ IDEA
2. Select "Open" and choose the project directory
3. Wait for Gradle sync to complete
4. Ensure all dependencies are downloaded

### Step 3: Configure Gradle Settings

In IntelliJ IDEA:

1. Go to **Settings** > **Build, Execution, Deployment** > **Build Tools** > **Gradle**
2. Set **Run tests using** to **IntelliJ IDEA**
3. Click **Apply** and **OK**

### Step 4: Verify Project Setup

1. Wait for Gradle sync to complete (check the bottom-right corner)
2. Ensure all dependencies are downloaded
3. Verify that test files are recognized (green play buttons should appear next to test methods)

## How to Run Tests

### Method 1: Run Individual Test Classes

#### For Schema Validation Tests:

1. Navigate to `src/test/java/tests/APISchemaVerificationTest.java`
2. Click the green play button next to the class name `APISchemaVerificationTest`
3. Select "Run 'APISchemaVerificationTest'"

#### For API Parameter Tests:

1. Navigate to `src/test/java/tests/APITest.java`
2. Click the green play button next to the class name `APITest`
3. Select "Run 'APITest'"

### Method 2: Run Individual Test Methods

1. Open the desired test file
2. Click the green play button next to any specific test method
3. Select "Run '{methodName}'"

## Test Execution Details

### APISchemaVerificationTest

- **Validations**:
    - API response structure validation
    - JSON schema compliance
    - Data integrity checks
- **Output**: Detailed response logging and validation results

### APITest

- **Test Cases**:
    - 20 companies data validation
    - 5 companies data validation
    - 1 company data validation
- **Output**: Response logging for each test case

## Expected Results

### Successful Test Execution

- All tests should pass with green checkmarks
- Console output will show API responses and validation details

## API Endpoint Information

- **Base URL**: `https://fakerapi.it/api/v1/companies`
- **Method**: GET
- **Parameters**:
    - `_quantity`: Number of companies to return (optional)
- **Response**: JSON array of company objects with nested address and contact information
