#!/usr/bin/env python
# -*- coding: utf-8 -*-

#import urllib2
import sys
import itertools
import requests

from xml.dom.minidom import parse
import xml.dom.minidom

from util import *


"""
	Run the search and creates a XML file
"""
def get_ieee_xml(string):

	site = "http://ieeexplore.ieee.org/gateway/ipsSearch.jsp?querytext=%s&hc=1000&sortfield=ti&sortorder=asc" % (string)
	xml_file = file("ieee.xml","w") #Create the file

	#This method uses urllib2 to read the content of the site
	#response = urllib2.urlopen(site) #Get the xml from IEEE query

	#Will use requests insted
	response = requests.get(url = site)
	response = response.text

	#Write the response in a valid XML file
	xml_file.write(response.encode('utf-8')) #Write the xml into the file

	#Just close the file
	xml_file.close()



"""
	Open the XML file and creates a dictionary with the information of every paper
"""
def process_xml():

	#Return values
	totalfound = None
	totalsearched = None
	titles   = []
	authors  = []
	keywords = []
	abstracts= []

	# Open XML document using minidom parser
	doc =  xml.dom.minidom.parse("ieee.xml")

	#Search for a error in the XML
	try:
		error = doc.getElementsByTagName("Error")[0]
		print 'There\'s a error in the XML file. Returning a empy list of studies. \n'
		return []

	#If not find a error, just continue the execution..
	except IndexError:
		pass

	totalfound = doc.getElementsByTagName("totalfound")[0]
	totalfound = totalfound.firstChild.data
	print "Total: ",totalfound

	totalsearched = doc.getElementsByTagName("totalsearched")[0]
	totalsearched = totalsearched.firstChild.data
	print "Total Searched: ",totalsearched

	documents = doc.getElementsByTagName("document")

	studies = [] #list of all studies

	for doc in documents:

		#Informations [title ,author,abstract,keys]
		study = []

		#Title
		title = ''
		try:
			title = doc.getElementsByTagName("title")[0].firstChild
		except IndexError:
			pass
			#print 'No childNodes for title element'

		if title:
			title= title.data.encode('utf-8').lower()
			#print "Title:", title
			titles.append(title)

		#Always add the value to the study list. This will mantain the  consistency of the elements
		study.append(title) #Add title to study


		#Authors
		author = ''
		try:
			author = doc.getElementsByTagName("authors")[0].firstChild
		except IndexError:
			pass
			#print 'No childNodes for author element'

		if author:
			author = author.data.split(";")
			author = [ a.encode('utf-8').strip().lower() for a in author]
			#print "Authors:", author
			authors.append(author)


		#Always add the value to the study list. This will mantain the  consistency of the elements
		study.append(author) #Add title to author


		#Abstract
		abstract = ''
		try:
			abstract = doc.getElementsByTagName("abstract")[0].firstChild

		except IndexError:
			pass
			#print 'No childNodes for abstract element'

		if abstract:
			abstract = abstract.data.encode('utf-8').lower()
			#print "Abstract:", abstract
			abstracts.append(abstract)

		#Always add the value to the study list. This will mantain the  consistency of the elements
		study.append(abstract) #Add abstract to the values of study


		#Keywords
		keys = []
		controlledterms = ''

		try:
			controlledterms = doc.getElementsByTagName("controlledterms")
		except IndexError:
			pass
			#print 'No childNodes for controlledterms element'

		for terms in controlledterms:
			num_key = terms.getElementsByTagName("term").length

			for i in range(num_key):
				key  = terms.getElementsByTagName("term")[i].firstChild.data.encode('utf-8').lower()
				keys.append(key)

		#Add a list of keys to the study list
		study.append(keys)

		#Keep to a list with all keywords
		keywords.append(keys)

		#Add the study to the list of studies
		studies.append(study)

	#Remove the redundance
	keywords = list(itertools.chain(*keywords)) #Concat all the lists inside one bigger
	keywords = list(set(keywords)) #Remove duplicates
	#print keywords

	return studies
