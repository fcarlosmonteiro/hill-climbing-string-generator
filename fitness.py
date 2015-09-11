#!/usr/bin/env python
# -*- coding: utf-8 -*-


#This import help to cause the return of a division into a float
from __future__ import division

from engine import *
from util import *


"""
	Defines the number of partial studies using keywords as fitness
"""
def keyword_fitness(studies, log = None):

	"""
		Args:
			studies - List with the studies extracted from the XML
			log - File to log the inforation about the execution
	"""

	#Logging
	info = 'I: Calculing the Keyword Fitness... \n'

	if log:
		log.write(info)
	else:
		print info

	#get the keywords from a file
	keywords = get_keywords()

	#list with the studies that contains all keywords
	partial_studies = []

	#Total fitness
	fitness_total = 0
	studies_w_fitness = 0

	#Informations for each study [title ,author,abstract,keys]
	for study in studies:

		cont = 0      #Number of keywords found inside each study
		fitness = 0  #fitness value for each study analised


		num_keys_study = len(study[3]) #Number os keywords for a stydy

		#For each keyword in the list of keywords extracted from the file..
		for key in keywords:

			#Get the keys of the study under analising
			keys_study = study[2]

			#If one key of the list of keywords is inside of the keywords of the study under analise, add cont..
			if key in keys_study:
				cont = cont +1

		#Now check the value of cont to define the fitness value for each study and for total fitness (fitness_total)

		#If number of keys < 0
		if cont <= 0:
			fitness = 0
			fitness_total = fitness_total + fitness

		#If number of keys < (num_keys/2)
		elif (0 < cont < (num_keys_study/2)):
			fitness = 0.3
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		#If number of keys = (num_keys/2)
		elif (cont == (num_keys_study/2)):
			fitness = 0.5
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		#If number of keys is > (num_keys/2)) and < num_keys
		elif (num_keys_study > cont > (num_keys_study/2)):
			fitness = 0.7
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		#If number of keys is higher than num_keys
		else:
			fitness = 1
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		if (fitness > 0):
			partial_studies.append([study,fitness])


	#FitnessK is equal to the total fitness divided by the number of studies
	if studies_w_fitness > 0:
		fitnessK = fitness_total/float(studies_w_fitness)
	else:
		fitnessK = 0


	#Loggin the information about the Keyword fitness
	info  = 'I: Number of studies with a valid fitness value: %d \n' % studies_w_fitness
	info2 = 'I: Keyword Fitness: %f \n' % fitnessK
	info3 = 'I: Number of partial studies (Fitness > 0.5): %d \n' % len(partial_studies)

	if log:
		log.write(info)
		log.write(info2)
		log.write(info3)
	else:
		print info
		print info2
		print info3

	return partial_studies, fitnessK



"""
	Defines the number of relevant studies
"""
def abstract_fitness(partial_studies, log = None):

	#get the keywords from a file
	keywords = get_keywords()

	#logging the abstract fitness
	info  = 'I: Calculing the Abstract Fitness... \n'
	info2 = 'I: Using the following Keywords: ' +  ','.join(keywords) + ' \n'
	if log:
		log.write(info)
		log.write(info2)
	else:
		print info
		print info2



	relevant_studies = []
	num_keywords = len(keywords) #Number of keywords informed

	fitness_total = 0
	studies_w_fitness = 0

	for study in partial_studies:

		cont = 0 #Number of keywords inside abstract
		fitness = 0 #Fitness

		for key in keywords:

			#Each study was the following composition [study,[keyword_fitnes]] where study = [title, author, [keywords], abstract]
			abstract = study[2]

			if key in abstract:
				cont = cont +1

		#If number of keys < 0
		if cont == 0:
			fitness = 0

		#If number of keys < (num_keys/2)
		elif (0 < cont < (num_keywords/2)):
			fitness = 0.3
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		#If number of keys = (num_keys/2)
		elif (cont == (num_keywords/2)):
			fitness = 0.5
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		#If number of keys is > (num_keys/2)) and < num_keys
		elif (num_keywords > cont > (num_keywords/2)):
			fitness = 0.7
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		#If number of keys is higher than num_keys
		else:
			fitness = 1
			fitness_total = fitness_total + fitness
			studies_w_fitness = studies_w_fitness + 1

		if (fitness >= 0.5):
			relevant_studies.append([study,fitness])

	#Calculate the value of fitnessA
	if studies_w_fitness:
		fitnessA = fitness_total / studies_w_fitness
	else:
		fitnessA = 0

	#Loggin the information about the Abstract fitness
	info =  'I: Number of studies with a valid abstract fitness value: %d \n' % studies_w_fitness
	info2 = 'I: Abstract Fitness: %f \n' % fitnessA
	info3 = 'I: Number of relevant studies (Fitness > 0.5): %d \n' % len(partial_studies)

	if log:
		log.write(info)
		log.write(info2)
		log.write(info3)
	else:
		print info
		print info2
		print info3


	return relevant_studies,fitnessA



"""
	Search the control  paper  in the base of results
"""
def control_paper_fitness(studies, log = None):

	"""
		Args:
			studies - List with the studies extracted from the XML
	"""

	#Will use just the name of the papers
	studies_titles = [item[0] for item in studies]

	#Method to acess the list of control studies
	control_list = get_control_list()


	#logging the abstract fitness
	info  = 'I: Calculing the Control List Fitness.. \n'
	info2 = 'I: Using the following control list: ' +  ','.join(control_list) + '\n'
	info3 = 'I: Number of studies in control list: %d \n' % len(control_list)
	if log:
		log.write(info)
		log.write(info2)
		log.write(info3)
	else:
		print info
		print info2
		print info3


	#Define some variables
	count = 0
	fitness_total = 0
	studies_w_fitness = 0

	#For each papel inside the control list..
	for paper in control_list:

		#Reduce the case sensitive of the string
		if isinstance(paper,str):
			paper = paper.lower()

		if paper in studies_titles:
			count = count + 1

	#Define the fitness value

	#fitnessCS = fitness
	fitnessCS = count/ len(control_list)

	#Loggin the information about the Keyword fitness
	info2 = 'I: Control Study Fitness: %f \n' % fitnessCS
	info3 = 'I: Number of controled studies found: %d \n' % count

	if log:
		log.write(info2)
		log.write(info3)
	else:
		print info2
		print info3

	return fitnessCS, count



"""
	Use all fitness values to calculate the total fitness
"""
def fitness_function(studies, controled_studies, log = None):

	"""
		Args:
			studies - List with the studies extracted from the XML
			controled_studies - List with the controled studies
	"""

	#logging the fitness_function
	info  = 'I: Calculing the Sensibility and Precision... \n'

	if log:
		log.write(info)

	else:
		print info


	#Get the number of controled studies
	number_of_controled_studies = len(controled_studies)

	#Get the fitness of controle sudies and the number of controle studies found
	if log:
		fitnessCS, identified_CS = control_paper_fitness(studies, log)
	else:
		fitnessCS, identified_CS = control_paper_fitness(studies)

	#Get the fitness of keywords and the list of relevant studies for that keywords
	if log:
		relevant_studies_k, fitnessK = keyword_fitness(studies,log)
	else:
		relevant_studies_k, fitnessK = keyword_fitness(studies)

	#Get the fitness of the abstract and the list of relevant studies for that abstracts
	relevant_studies_k = [s[0] for s in relevant_studies_k]
	if log:
		relevant_studies_a, fitnessA = abstract_fitness(relevant_studies_k,log)
	else:
		relevant_studies_a, fitnessA = abstract_fitness(relevant_studies_k)

	#Number of controled studies studies minus the number of controled studies found
	irrelevant_studies = number_of_controled_studies - identified_CS
	total_relevant = (len(relevant_studies_k) + len(relevant_studies_a)) / 2

	#Calculate Precision and sensibility. This metrics are defined in the paper
	try:
		sensibility = (len(relevant_studies_a) / (len(relevant_studies_a) + identified_CS))
	except ZeroDivisionError:
		sensibility = 0

	try:
		precision = (len(relevant_studies_a) / (len(relevant_studies_a) + irrelevant_studies))
	except ZeroDivisionError:
		precision = 0


	print 'I: Number of partial studies (Keywords): %d \n' % len(relevant_studies_k)
	print 'I: Number of relevant studies (Abstract): %d \n' % len(relevant_studies_a)
	print 'I: Number of identified studies (Control list): %d \n' % identified_CS
	print 'I: Number of irrelevant studies: %d \n' % irrelevant_studies

	#Total fitness is the mean of both
	total_fitness = (sensibility + precision) / 2

	#Loggin the information about the Keyword fitness
	info =  'I: Sensibility value: %f \n' % sensibility
	info2 = 'I: Precision value: %f \n' % precision
	info3 = 'I: Total Fitness: %f \n' % total_fitness

	if log:
		log.write(info)
		log.write(info2)
		log.write(info3)
	else:
		print info
		print info2
		print info3

	return total_fitness
