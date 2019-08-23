# FantasyFootballPlayoffCalculator
This is a application that I created for my fantasy football league.

The purpose of this application is to predict the outcome of each matchup to predict what you need to do to get into 
the playoffs.

This is built using java.swing and java.JDBC

I've built the database on my local machine using MySQL. Once the application begins to run it populates the LeftPanel 
and RightPanel with its original values. The left panel stores the matchups and gives you the opportunity to predict 
the outcomes of each matchup. You can choose which week you'd like to predict via the combo box, and based on your 
selection the JTextFields get populated with  that weeks matchups. Once you click calculate it pushes those values 
into the tempStandings table. You can also click reset and that sets the tempStandings values to all zeros. 

The right panel houses the standings. It is originally populated with the original standings values. Once you click on the
'Update Standings' button it combines the values of the standings and tempStandings tables via a inner join query and 
pushes those values into the table.

Next steps include:

1) Consolidate the functionalities of the 'Calculate' and 'Update Standings' buttons so the standings are updated
once you click on the 'Calculate' button.
2) Use RMI or some sort of website crawler to give the database its values. Currently the database is given its values 
via a query that I have built.
3) Integrate the database into my application so I can distribute the application to the members on my league. 
