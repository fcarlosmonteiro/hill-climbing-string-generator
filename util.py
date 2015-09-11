#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import os
from itertools import chain

"""
	Run pair therms in a list
"""
def pairs(lst):
    i = iter(lst)
    first = prev = item = i.next()
    for item in i:
        yield prev, item
        prev = item
    yield item, first



"""
	Break a string into a list with therms
"""
def break_string_in_list(string):

	#List with the elements organized
	final_list = []

	#Will create a list where each element is correspondet to the PICO approach.
	splited_string = string.split('AND')

	#Next step is remove quotes and parenthesis for each element and break the synonymous
	for elements in splited_string:

		elements = elements.replace('"','') #remove quotes
		elements = elements.replace(')','') #remove parenthesis
		elements = elements.replace('(','') #remove parenthesis

		#Now will turn elements in a LIST where each index is correspondent to a synonymous
		elements = elements.split('OR')

		#remove spaces at the beggining and end
		elements = [e.strip() for e in elements]

		#Each element is a correspondent of PICO
		final_list.append(elements)

	return final_list



"""
	Update StringGen and Original txt files
"""
def update_search_string_files(best_string, search_string_name = None, original_name = None):

	"""
		Args:
			best_string = Strig with the best fitness value. It can be a string or a list. If it's is a string. First convert the string into a list..
			search_string_name = Name of the file with the search string used in the java program
			original_name = Name of the file with the original search string used in the java program
	"""

	#Verify if the search_string_name was especified
	if not search_string_name:

		#The file will always be the same
		search_string_file = open('StringGen.txt','wb')
	else:

		#The file will be passed by parameter
		search_string_file = open(search_string_name,'wb')

	#Verify if the original_name was especified
	if not original_name:

		#The file will always be the same
		original_file = open('Original.txt','wb')
	else:

		#The file will be passed by parameter
		original_file = open(original_name,'wb')


	#Add a extra check to verify if the parameter best_string is a string or a list

	if isinstance(best_string, str):
		#format the therms of the string into a list
		formated_string_in_list = break_string_in_list(best_string)

	elif isinstance(best_string, list):
		formated_string_in_list = best_string
	else:
		print 'You are using the function (util.py:update_search_string_files()) if wrong parameters. Check your code!'
		sys.exit(0)


	#Now we have all the information in the right format. Let's update the files
	for elements in formated_string_in_list:

		#precaution..
		elements = list(set([i if not  isinstance(i,list) else j  for i in elements for j in i])) #remove nested list if it exists. Convert [a,b,[c],d] into [a,b,c,d]

		#For each word in the list of words
		for element in elements:

			#if isinstance(element,list):
				#element = ' '.join(str(e) for e in element)

			search_string_file.write(element)
			search_string_file.write('\n')

			original_file.write(element)
			original_file.write('\n')

		#When write all synonymous, skip one line
		search_string_file.write('\n')
		original_file.write('\n')


	#Close the files
	search_string_file.close()
	original_file.close()


"""
    Get all string created using the neighborhood defined inside the paper
"""
def get_all_strings(directory):

    """
        parameters:
            directory - Where the folders with the strings are located
            txt_file  - A file with the information off the initial string 'Replace the use of the DSL proposed by Dureli'
    """

    #At this point there are 4 directories each one with a file that contains a search string to evaluate

    #Neighborhood list
    neighbor_list = []

    #Original String
    original_string = ''

    #Orignal String and neighborhood files
    files_list = ['Original.txt','Nb0.txt','Nb2.txt','Nb2-0.txt']
    dirs_list = ['OriginalString','NB01','NB02','NB03','NB04']

    #Get inside the directory that are the directories with the strings
    r = os.chdir(directory)

    #Walkthrough the main directory
    for root, dirs, files in os.walk(directory):

        #For every dir inside root dir
        for d in dirs:

            #If that dir is inside of dirs_list
            if d in dirs_list:

                #Gona look for the files inside this dir
                for root, dirs, files in os.walk(d):

                    #Files is a list with the name of the files. Gona get the name of the file..
                    for f in files:

                        #Its a Neighbor
                        if 'Nb' in f:

                            #Create a file object that represents the file existing inside the dir
                            nb_file = open(d+'/'+ f, 'rb')

                            #Run get_string method to extract the string that are inside the file
                            search_string = get_string(nb_file)

                            #Avoid duplicates
                            if search_string not in neighbor_list:

                                #Add the string to the neighborhood list
                                neighbor_list.append(search_string)

                            #Close the nb_file just for precaution
                            nb_file.close()

                        #Original String
                        else:

                            original_file = open(d+'/'+ f, 'rb')
                            original_string = get_string(original_file)

                            original_file.close()


    #return a list with the neighborhood for the string used in the java program
    return original_string,neighbor_list



"""
	Pass a file as parameter and recive the search_string contained inside that file
"""
def get_string(file_nb):

	"""
		Args:
			nb_file = File that contains a valid string neighborhood
	"""

	search_string = str()

	#Simple run over the lines of the file and add the content to the search_string var
	for line in file_nb:
		search_string = search_string + line

	#At the end return the search_string
	return search_string



"""
	Get the keywords from a file
"""
def get_keywords():

	"""
		Args:
			keywords_file = File that list all keywords
	"""

	#The file will always be the same
	keywords_file = open('keywords.txt','rb')

	#A empty list
	keywords = []

	#Every line in the file is correspondent to a keyword. So just go through the lines removes the "\ n" and add to the list
	for line in keywords_file:
		if line != '':
			line = line.lower()
			keywords.append(line.strip(" \n"))

	#Close the file
	keywords_file.close()

	return keywords


"""
	Get the control list from a file
"""
def get_control_list():

	"""
		Args:
			control_list__file = File that list all keywords
	"""

	#The file will always be the same
	control_list__file = open('control_list.txt','rb')

	#A empty list
	control_list = []

	#Every line in the file is correspondent to a paper. So just go through the lines removes the "\ n" and add to the list
	for line in control_list__file:
		if line != '':
			line = line.lower()
			control_list.append(line.strip(" \n"))

	#Close the file
	control_list__file.close()

	return control_list
