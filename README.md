# StreamingRentarPeliculas
Microservicios intermedios para proyecto de SOA: Streaming de películas

#Colas empleadas en los microservicios:
#StreamingCobrarRenta
queue.name.in = stream.cr.in
queue.name.out = stream.cr.error
queue.name.next = stream.rent.in

#StreamingRenta
queue.name.in = stream.rent.in
queue.name.out = stream.rent.error
queue.name.next = stream.repp.in
