#  Password Strength Analyzer & Generator

An engineering-grade Java application designed to evaluate password vulnerability using structural heuristics, Shannon Entropy, and cryptographic resilience metrics. This project shifts away from basic character-counting tools by providing an evaluation of a password's actual resistance to brute-force attacks.

## Features

- **Multi-Factor Structural Heuristics:** Evaluates character variety (Uppercase, Lowercase, Numerical Digits, and Special Symbols) using optimized Linear-Time $\mathcal{O}(N)$ Regular Expressions.
- **Shannon Entropy Quantification:** Calculates the mathematical bits of entropy based on the active character pool size ($R$) and length ($L$).
- **Cryptographically Secure Generator:** Leverages `java.security.SecureRandom` to produce high-entropy, unpredictable passwords resistant to seed-prediction attacks.
- **Dictionary Attack Prevention:** (Optional Upgrade) Flags common anti-patterns and blocklisted sequential strings instantly.

---

## Core Engineering Concepts

### 1. Shannon Entropy Formula
The core cryptographic strength is calculated using the following logarithmic equation:

$$Entropy = L \times \log_2(R)$$

Where:
- **$L$** = Total length of the password string.
- **$R$** = Total pool size of the possible character sets used.

### 2. Strength Threshold Matrix

| Entropy Level (Bits) | Structural Score | Assigned Strength Classification |
| :--- | :--- | :--- |
| $< 40$ bits | $\le 2$ Rules | **WEAK** (Vulnerable to instant cracking) |
| $40 - 59$ bits | $3 - 4$ Rules | **MEDIUM** (Prone to offline dictionary attacks) |
| $60 - 79$ bits | $5$ Rules | **STRONG** (Highly resilient) |
| $\ge 80$ bits | $6$ Rules | **VERY STRONG / EXCELLENT** (Military grade) |

---

## the system result

Tech Stack & Environment

- **Language:** Java 8 or higher (JDK 11/17 recommended)
- **Paradigm:** Object-Oriented Programming (OOP)
- **Core APIs used:** `java.util.regex.Pattern`, `java.security.SecureRandom`, `java.util.Scanner`

---

## Execution Instructions

### Prerequisites
Ensure you have the Java Development Kit (JDK) installed and configured in your system environment variables.

### Compilation
Open your terminal/command prompt in the root directory containing your source `.java` files and run:
```bash
javac MainApp.java PasswordValidator.java StrengthResult.java
```

### Running the Application
Execute the compiled bytecode with the following command:
```bash
java MainApp



## project dealed by:


