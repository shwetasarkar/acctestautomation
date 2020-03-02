Feature: search jobs on career page 


Scenario Outline: 1. search "<JobName>" on career page 
	Given I am on homepage
	When I click on about us
	Then I click on working at ACC
	And I click on careers and navigate to Careers page
	Then I search <JobName> jobs in <Location>
	And I verify <JobName> in the results

		
	Examples: 
		|JobName     |Location|
		|"Test Engineer"|Wellington|
	#	|"Team Leader" |Auckland|
		
		

