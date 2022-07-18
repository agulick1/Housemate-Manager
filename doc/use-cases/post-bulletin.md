### Use case - Post to Bulletin

**Scope**
- Housemate Management Application 

**Level**
- User goal

**Primary actor**
- Poster

**Stakeholders and interests**
- Poster: Wants to convey a message to rest of housemates. Wants to know who has seen the message.
- Viewers: Want convenient access to the message. Want to respond to the Poster.

**Preconditions**
- Poster and Viewers are housemates registered under a same house.

**Postconditions**
- The bulletin is available in the Bulletin Board for viewing
- Viewers have been notified.

**Main success scenario**
1. Poster opens the Bulletin Board and creates a new bulletin.
2. Poster inputs the title and the message into the prompt.
3. System saves the bulletin and sends notification to Viewers.
4. Viewers open and read the bulletin.
5. System logs initial access.

**Extensions**

2a. Empty input:
1. System signals error and rejects input.
2. Poster fills in the prompts.

4a. Viewer replies:
1. Viewer adds comment to the bulletin.
2. System notifies the Poster.

*a. At any time, Poster deletes their bulletin:
1. System hides the bulletin from view and logs the action.

*b. At any time, System crashes:
1. User restarts system.
2. System fetches any changes from Hub

**Special requirements**
- Touch screen UI with flexible dimensions
- Notification delivery time within 5 seconds
- Support for common languages

**Technology and data variations**
- N/A

**Frequency of occurrence**
- Moderate-high frequency

**Miscellaneous**
- N/A