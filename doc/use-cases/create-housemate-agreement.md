### Use case - Create Housemate Agreement

**Scope**
- Housemate Management Application

**Level**
- User goal

**Primary actor**
- Poster

**Stakeholders and interests**
- Poster: Wants to propose an agreement to the rest of the house. Wants to how viewers interacted with the agreement.
- Viewer: Wants convenient access to the proposal. Wants to respond to the Poster.

**Preconditions**
- Poster and Viewers are housemates registered under a same house.

***Postconditions**
- The agreement is available in the Bulletin Board for viewing.
- Viewers have been notified and agreed to the proposal.

**Main success scenario**
1. Poster opens the Bulletin Board and creates a new bulletin.
2. Poster inputs the title and the message into the prompt marks it as proposal.
3. System saves the proposal and sends notification to Viewers.
4. Viewers open and read the bulletin.
5. System the logs initial access on the bulletin. 
6. Viewers approve the proposal.
7. System converts the proposal into a Housemate Agreement
8. System pins the Housemate Agreement on the top of Bulletin Board.


**Extensions**

2a. Empty input:
1. System signals error and rejects input.
2. Poster fills in the prompts.

4a. Viewer replies:
1. Viewer adds comment to the bulletin.
2. System notifies the Poster.

6a. Viewer disapproves the proposal:
1. System notifies the Poster
2. Poster creates a new revised proposal with the same name
3. System replaces the old proposal with the new one

7a. Approved proposal has the same name as the pre-existing Housemate Agreement:
1. System replaces the old Housemate Agreement with the new proposal.

*a. At any time, System crashes:
1. User restarts system.
2. System fetches any changes from Hub

**Special requirements**
- Touch screen UI with flexible dimensions
- Notification delivery time within 5 seconds
- Support for common languages

**Technology and data variations**
- N/A

**Frequency of occurrence**
- Moderate frequency

**Miscellaneous**
- N/A