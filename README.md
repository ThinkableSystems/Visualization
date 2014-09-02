Visualization
=============

Tool for doing visualization in javascript

Once you have git installed on your machine, in you terminal, go to your eclipse work space folder and type in 

git clone git@github.com:ThinkableSystems/Visualization.git

If you have issues doing this, it means that you have not put your public key onto your github account.  You can do this by going to 
~/.ssh, and opening your id_rsa.pub file.  Copy everything in there, go back to you github account, click on settings (upper right gear icon)
and click on SSH keys.  Click on Add key, put in a title of your choice, and paste the ssh public key you copied earlier.
Doing this will allow you to pull and push code to the repository without having to type in your username and password every single time.

This should put the visualization software on your machine.

You should be able to open eclipse and start tooling around with it.

If something goes horribly wrong and you cannot get the code back to its working state, you can close eclipse, go to the 
Visualization folder in you terminal, and type

git reset --hard

This will take the application back to the initials state

Finally here is a really really good hands on training site for Git
https://try.github.io/levels/1/challenges/1

Please let me know if you have any issues
