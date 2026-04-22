# Max-Profit
Max Profit Scheduling Problem solved using brute-force simulation in Java to maximize earnings based on construction time and completion-based revenue model.
Problem Statement

Problem Overview :

Mr. X owns a large piece of land and can build three types of properties:

| Building            | Construction Time | Earnings per Unit Time |
| ------------------- | ----------------- | ---------------------- |
| Theatre (T)         | 5 units           | $1500                  |
| Pub (P)             | 4 units           | $1000                  |
| Commercial Park (C) | 10 units          | $2000                  |

🔒 Constraints

Only one building can be constructed at a time
Buildings start earning only after completion
Total available time is n units
Goal: Maximize total earnings

🎯 Objective

Find the optimal combination and construction sequence of buildings such that:

💰 Total earnings are maximized within the given time limit.

🧠 Core Insight

Unlike standard scheduling problems, profit is time-dependent after completion, not fixed.

Each building contributes:

Profit = Earnings per unit time × (Total time - Completion time)

👉 This makes construction order critical to maximizing profit.

🛠️ Approach

🔍 Strategy: Brute Force + Simulation

We explore all valid configurations of building counts and evaluate each using simulation.

Step-by-step breakdown:

1️⃣ Generate all valid combinations
Number of Theatres (T)
Number of Pubs (P)
Number of Commercial Parks (C)

Such that:

Total construction time ≤ n


🔄 Algorithm Flow

For each (T, P, C):
    If total_time ≤ n:
        simulate construction in sequence
        calculate profit using completion time
        update global maximum

