<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:template match="/">
<html>
   <head> <title>TP1</title></head>

<body>
<center>
      <h1>Universite de : <xsl:value-of select="universite/@name"/></h1>
<p>
Faculte :
<xsl:value-of select="universite/faculte/@name"/>
</p>

<p>
departement :
<xsl:value-of select="universite/faculte/departement/@name"/>
</p>

<p> Formations de types :</p>
<p>
nombre de formations: <xsl:value-of select="count(//@type)"/>
</p>
<xsl:for-each select="universite/faculte/departement/formations/formation">

<p>
<xsl:value-of select="@type"/>
Duree:
<xsl:value-of select="duree"/>
</p>

</xsl:for-each>

<p> Specialites du master :</p>
<xsl:for-each select="universite/faculte/departement/formations/formation/specialites/specialite">
<p>
 Name:
<xsl:value-of select="@name"/>
</p>

</xsl:for-each>

</center>

</body>

</html>

</xsl:template>

</xsl:stylesheet>



