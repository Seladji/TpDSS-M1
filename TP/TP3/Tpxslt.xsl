<?xml version="1.0" encoding="UTF-8"?>

<!-- New document created with EditiX at Wed Dec 08 11:55:13 CET 2021 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html"/>
	
	<xsl:template match="/">
	<html>
		<body>
		<xsl:for-each select="variable/valeur">
		
<xsl:if test="./@note='10'">
		
    
		
        <xsl:value-of select="./nom"/>
		
        <xsl:value-of select="./prenom"/>
		
   
		
</xsl:if>
		
</xsl:for-each>
		
<xsl:for-each select="variable/valeur">
		
<xsl:choose>
		
         <xsl:when test="./@note='10'"><p>pas mal</p></xsl:when>
		
          <xsl:when test="./@note='13"> <p>moyen</p></xsl:when>
                                        <xsl:when test="./@note='16"><p>super</p> </xsl:when>
		
         <xsl:otherwise><p>pas de note</p></xsl:otherwise>
		
         
		
</xsl:choose>
		
</xsl:for-each>

		</body>
	</html>
	</xsl:template>

</xsl:stylesheet>


