(: for $n in //marque
order by $n
return $n :)

(: for $nbr in count(//voiture)
return $nbr :)

(: for $voiture in //voiture
where $voiture/prix/@M="DA"
and $voiture/prix >= "7000000"
return $voiture/@code :)

(: for $v in distinct-values(//villeVente)
return $v :)
(:
<voiture mq="{data(//voiture[4]/marque)}">
{
for $voitureMarque in //voiture[@code="4"]/prix

return <prix>{$voitureMarque/text()}</prix>
}
</voiture>:)
(:
for $n in //voiture[2]
return $n :)

for $i in //voiture
return if($i/count(villeVente)>2)
then <voiture code="{data($i/@code)}">
<villes>{data($i/villeVente)}</villes>
</voiture>
else <voiture code="{data($i/@code)}">
<villes>{data($i/villeVente)}</villes>
</voiture>