------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Cryptogram
PURPOSE OF PROJECT: Capstone
VERSION or DATE: 10 May 2016
DEPENDENCIES:
HOW TO START THIS PROJECT: Run the main method of the Cryptogram class
AUTHORS: Justin Huang

OVERVIEW: My capstone project is a Cryptogram GUI program that allows the user to encode
    messages into code or decode code into messages. The user can choose whether to encode
    or decode a string, enter their message or code into a text field, and have the program
    automatically produce the corresponding code or message. If desired, the user can also
    specify how many characters they would like each character of their given string to be
    shifted, based on a preset order of all possible characters on the keyboard.
    
SYNTHESIS: My Cryptogram GUI capstone program synthesizes various concepts learned
    throughout this school year by incorporating...
        The creation of Graphical User Interfaces and use of a few components
        The use of listeners to assign different tasks to different GUI components
        The use of string indexing
        The use of different levels of access for different methods depending on who should
            be able to use them
        The use of static final variables and static methods so that there isn't a need to
            create an object just to be able to use a certain constant or method
        
    My Cryptogram GUI capstone program also required additional research of new concepts
    because I had to research about and incorporate...
        The use of components we did not learn about in class, specifically radio buttons
            and text fields (also setting editability for text fields)
        The use of listeners we did not learn about in class, specifically the ItemListener
            which listens for radio button events
        The use of absolute positioning to position the components within the JPanel
        The setting of default values for several components

USER INSTRUCTIONS:
1) To start the Cryptogram GUI program, run the main method of the Cryptogram class.
2) Select either the "Encode" or "Decode" radio button depending on what you want to do.
3) Type your message or code into the first editable text field.
    Labeled "Message:" if you chose "Encode" or "Code:" if you chose "Decode"
4) Type the number of characters you would like to shift your message or code into the
    second editable text field labeled "Number of Characters to Shift:".
    If not sure, leave as "1".
5) Click the "Go" button and your code or message will appear in the uneditable text field.
    If the character shift text field contains anything other than an integer, an
    "Error" message will appear.