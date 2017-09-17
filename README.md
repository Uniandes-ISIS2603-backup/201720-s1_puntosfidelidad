# s1_puntosfidelidad
Repositorio del proyecto de puntos de fidelidad del grupo 5 de la sección 1
UNIT NAME = puntosfidelidadPU

# Integrantes
Nombre|Correo|Rol
:--|:--|:--
Camilo Sánchez Salamanca|ca.sanchez38|Líder
Julían Alberto Manrique Puerto|ja.manrique|Líder de Desarrollo/Líder de Proceso y la Calidad
Alvaro Alfonso Yepes Bonilla|aa.yepes|Líder de Soporte 
Sebástian Cespedes Otalora|s.cespedes10|Líder de Diseño Web
Laura Valeria Vanegas García|lv.vanegas10|Líder de Planeación

# Tabla de contenidos

 - [Recurso Compra](#recurso-compra)
    - [GET /compra](#GET-/compra)
    - [GET /compra/{id}](#GET-/compra/{id})
    - [POST /compra](#POST-/compra)
    - [PUT /compra/{id}](#PUT-/compra/{id})
    - [DELETE /compra/{id}](#DELETE-/compra/{id})
    - [GET compra/{compraid}/producto](#GET-books/{compraid}/producto)
    - [GET compra/{compraid}/producto/{productoid}](#GET-compra/{compraid}/producto/{productoid})
    - [POST compra/{compraid}/producto/{productoid}](#POST-compra/{compraid}/producto/{productoid})
    - [PUT compra/{compraid}/producto](#PUT-compra/{compraid}/producto)
    - [DELETE compra/{compraid}/producto/{productoid}](#DELETE-compra/{compraid}/producto/{productoid}])
    
  - [Recurso Administrador](#recurso-administrador)
    - [GET /administradores](#GET-/administradores)
    - [GET /administradores/{id}](#GET-/administradores/{id})
    - [POST /administradores](#POST-/administradores)
    - [PUT /administradores/{id}](#PUT-/administradores/{id})
    - [DELETE /administradores/{id}](#DELETE-/administradores/{id})
    - [GET administradores/{administradoresid}/restaurante](#GET-administradores/{administradoresid}/restaurante)
    - [GET administradores/{administradoresid}/restaurante/{restauranteid}](#GET-administradores/{administradoresid}/restaurante/{restauranteid})
    - [POST administradores/{administradoresid}/restaurante/{restauranteid}](#POST-administradores/{administradoresid}/restaurante/{restauranteid})   
    - [PUT administradores/{administradoresid}/restaurante](#POST-/POSTadministradores/{administradoresid}/restaurante)
    - [DELETE administradores/{administradoresid}/restaurante/{restauranteid}](#DELETE-/administradores/{administradoresid}/restaurante/{restauranteid})  
    
  - [Recurso Restaurante](#recurso-restaurante)
    - [GET /restaurantes](#GET-/restaurantes)
    - [GET /restaurantes/{id}](#GET-/restaurantes/{id})
    - [POST /restaurantes](#POST-/restaurantes)
    - [PUT /restaurantes/{id}](#PUT-/restaurantes/{id})
    - [DELETE /restaurantes/{id}](#DELETE-/restaurantes/{id})
    - [GET restaurantes/{restaurantesid}/sucursales](#GET-restaurantes/{restaurantesid}/sucursales)
    - [GET restaurantes/{restaurantesid}/sucursales/{sucursalesid}](#GET-restaurantes/{restaurantesid}/sucursales/{sucursalesid})
    - [POST restaurantes/{restaurantesid}/sucursales/{sucursalesid}](#POST-restaurantes/{restaurantesid}/sucursales/{sucursalesid})   
    - [PUT restaurantes/{restaurantesid}/sucursales](#POST-/POST restaurantes/{restaurantesid}/sucursales)
    - [DELETE restaurantes/{restaurantesid}/sucursales /{sucursalesid}](#DELETE-/restaurantes/{restaurantesid}/sucursales/{sucursalesid})
    - [GET restaurantes/{restaurantesid}/productosCanjeables](#GET-restaurantes/{restaurantesid}/productosCanjeables)
    - [GET restaurantes/{restaurantesid}/productosCanjeables/{productosCanjeablesid}](#GET-restaurantes/{restaurantesid}/productosCanjeables/{productosCanjeablesid})
    - [POST restaurantes/{restaurantesid}/productosCanjeables/{productosCanjeablesid}](#POST-restaurantes/{restaurantesid}/productosCanjeables/{productosCanjeablesid})   
    - [PUT restaurantes/{restaurantesid}/productosCanjeables](#POST-/POSTrestaurantes/{restaurantesid}/productosCanjeables)
    - [DELETE restaurantes/{restaurantesid}/productosCanjeables/{productosCanjeablesid}](#DELETE-/restaurantes/{restaurantesid}/productosCanjeables/{productosCanjeablesid})
    - [GET restaurantes/{restaurantesid}/eventos](#GET-restaurantes/{restaurantesid}/eventos)
    - [GET restaurantes/{restaurantesid}/eventos/{eventosid}](#GET-restaurantes/{restaurantesid}/eventos/{eventosid})
    - [POST restaurantes/{restaurantesid}/eventos/{eventosid}](#POST-restaurantes/{restaurantesid}/eventos/{eventosid})   
    - [PUT restaurantes/{restaurantesid}/eventos](#POST-/POSTrestaurantes/{restaurantesid}/eventos)
    - [DELETE restaurantes/{restaurantesid}/eventos/{eventosid}](#DELETE-/restaurantes/{restaurantesid}/eventos/{eventosid})
    
- [Recurso Sucursal](#recurso-sucursal)
    - [GET /sucursales](#GET-/sucursales)
    - [GET /sucursales/{id}](#GET-/sucursales/{nombre})
    - [POST /sucursales](#POST-/sucursales)
    - [PUT /sucursales/{id}](#PUT/sucursales/{id})
    - [DELETE /sucursales/{id}](#DELETE/sucursales/{id})
    - [GET /sucursales/{id}/comentarios](#GET-/sucursales/{id}/comentarios)
    - [GET /sucursales/{id}/comentarios/{}](#GET-/sucursales/{id}/comentarios)
    - [POST /sucursales/{id}/comentarios](#POST-/sucursales/{id}/comentarios)
    - [PUT /sucursales/{id}/comentarios/{}](#PUT-/sucursales/{id}/comentarios)
    - [DELETE /sucursales/{id}/comentarios/{}](#DELETE-/sucursales/{id}/comentarios)
    - [GET /sucursales/{id}/compras](#GET-/sucursales/{id}/compras)
    - [GET /sucursales/{id}/compras/{idCompra}](#GET-/sucursales/{id}/compras/{idCompra})
    - [POST /sucursales/{id}/compras](#POST-/sucursales/{id}/compras)
    - [PUT /sucursales/{id}/compras/{idCompra}](#PUT-/sucursales/{id}/compras/{idCompra})
    - [DELETE /sucursales/{id}/compras/{idCompra}](#PUT-/sucursales/{id}/compras/{idCompra})
    
- [Recurso Producto](#recurso-producto)
    - [GET /producto](#GET-/producto)
    - [GET /producto/{id}](#GET-/producto/{id})
    - [POST /producto](#POST-/producto)
    - [PUT /producto/{id}](#PUT-/producto/{id})
    - [DELETE /producto/{id}](#DELETE-/producto/{id})
    
- [Recurso Cliente](#recurso-cliente)
    - [GET /clientes](#GET-/clientes)
    - [GET /clientes/{id}](#GET-/clientes/{id})
    - [POST /clientes](#POST-/clientes)
    - [PUT /clientes/{id}](#PUT-/clientes/{id})
    - [DELETE /clientes/{id}](#DELETE-/clientes/{id})
    - [GET clientes/{clientesid}/tarjetasDeCredito](#GET-clientes/{clientesid}/tarjetasDeCredito)
    - [GET clientes/{clientesid}/tarjetasDeCredito/{tarjetasDeCreditoid}](#GET-clientes/{clientesid}/tarjetasDeCredito/{tarjetasDeCreditoid})
    - [POST clientes/{clientesid}/tarjetasDeCredito/{tarjetasDeCreditoid}](#POST-/clientes/{clientesid}/tarjetasDeCredito/{tarjetasDeCreditoid})   
    - [PUT clientes/{clientesid}/tarjetasDeCredito](#PUT-/clientes/{clientesid}/tarjetasDeCredito)
    - [DELETE clientes/{clientesid}/tarjetasDeCredito/{tarjetasDeCreditoid}](#DELETE-/clientes/{clientesid}/tarjetasDeCredito/{tarjetasDeCreditoid})
    - [GET clientes/{clientesid}/tarjetasDePuntos](#GET-clientes/{clientesid}/tarjetasDePuntos)
    - [GET clientes/{clientesid}/tarjetasDePuntos/{tarjetasDePuntosid}](#GET-clientes/{clientesid}/tarjetasDeCredito/{tarjetasDePuntosid})
    - [POST clientes/{clientesid}/tarjetasDePuntos/{tarjetasDePuntosid}](#POST-clientes/{clientesid}/tarjetasDePuntos/{tarjetasDePuntosid})   
    - [PUT clientes/{clientesid}/tarjetasDePuntos](#PUT-/clientes/{clientesid}/tarjetasDePuntos)
    - [DELETE clientes/{clientesid}/tarjetasDePuntos/{tarjetasDePuntosid}](#DELETE-/clientes/{clientesid}/tarjetasDeCredito/{tarjetasDePuntosid})
    - [GET clientes/{clientesid}/recargas](#GET-clientes/{clientesid}/recargas)
    - [GET clientes/{clientesid}/recargas/{recargasid}](#GET-clientes/{clientesid}/recargas/{recargasid})
    - [POST clientes/{clientesid}/recargas/{recargasid}](#POST-clientes/{clientesid}/recargas/{recargasid})   
    - [PUT clientes/{clientesid}/recargas](#PUT-/clientes/{clientesid}/recargas)
    - [DELETE clientes/{clientesid}/recargas/{recargasid}](#DELETE-/clientes/{clientesid}/recargas/{recargasid})
    - [GET clientes/{clientesid}/compras](#GET-clientes/{clientesid}/compras)
    - [GET clientes/{clientesid}/compras/{comprasid}](#GET-clientes/{clientesid}/compras/{comprasid})
    - [POST clientes/{clientesid}/compras/{comprasid}](#POST-clientes/{clientesid}/compras/{comprasid})   
    - [PUT clientes/{clientesid}/compras](#PUT-/clientes/{clientesid}/compras)
    - [DELETE clientes/{clientesid}/compras/{comprasid}](#DELETE-/clientes/{clientesid}/compras/{comprasid})
    - [GET clientes/{clientesid}/comentarios](#GET-clientes/{clientesid}/comentarios)
    - [GET clientes/{clientesid}/comentarios/{comentariosid}](#GET-clientes/{clientesid}/comentarios/{comentariosid})
    - [POST clientes/{clientesid}/comentarios/{comentariosid}](#POST-clientes/{clientesid}/comentarios/{comentariosid})   
    - [PUT clientes/{clientesid}/comentarios](#PUT-/clientes/{clientesid}/comentarios)
    - [DELETE clientes/{clientesid}/comentarios/{comentariosid}](#DELETE-/clientes/{clientesid}/comentarios/{comentariosid})
    
 - [Recurso Recarga](#recurso-recarga)
    - [GET /recargas](#GET-/recargas)
    - [GET /recargas/{id}](#GET-/recargas/{id})
    - [POST /recargas](#POST-/recargas)
    - [PUT /recargas/{id}](#PUT-/recargas/{id})
    - [DELETE /recargas/{id}](#DELETE-/recargas/{id})
    
 - [Recurso TarjetaDeCredito](#recurso-tarjetadecredito)
    - [GET /tarjetasDeCredito](#GET-/tarjetasDeCredito)
    - [GET /tarjetasDeCredito/{id}](#GET-/tarjetasDeCredito/{tarjetasDeCreditoid})
    - [POST /tarjetasDeCredito](#POST-/tarjetasDeCredito)
    - [PUT /tarjetasDeCredito/{id}](#PUT-/tarjetasDeCredito/{tarjetasDeCreditoid})
    - [DELETE /tarjetasDeCredito/{id}](#DELETE-/tarjetasDeCredito/{tarjetasDeCreditoid})

- [Recurso Evento](#recurso-evento)
    - [GET /eventos](#GET-/eventos)
    - [GET /eventos/{id}](#GET-/eventos/{nombre})
    - [POST /eventos](#POST-/eventos)
    - [PUT /eventos/{id}](#PUT-/eventos/{nombre})
    - [DELETE /eventos/{id}](#DELETE-/eventos/{nombre})
    - [GET eventos/{eventoNombre}/ubicaciones](#GET-eventos/{eventoNombre}/ubicaciones)
    - [GET eventos/{eventoNombre}/ubicaciones/{ubicacionDireccion}](#GET-eventos/{eventoNombre}/ubicaciones/{ubicacionDireccion})
    - [POST eventos/{eventoNombre}/ubicaciones/{ubicacionDireccion}](#POST-eventos/{eventoNombre}/ubicaciones/{ubicacionDireccion})
    - [PUT eventos/{eventoNombre}/ubicaciones](#PUT-eventos/{eventoNombre}/ubicaciones)
    - [DELETE eventos/{eventoNombre}/ubicaciones/{ubicacionDireccion}](#DELETE-eventos/{eventoNombre}/ubicaciones/{ubicacionDireccion}])
    - [GET eventos/{eventoNombre}/restaurantes](#GET-eventos/{eventoNombre}/ubicaciones)
    - [GET eventos/{eventoNombre}/restaurantes/{idRestaurante}](#GET-eventos/{eventoNombre}/restaurantes/{idRestaurante})
    - [POST eventos/{eventoNombre}/restaurantes/{idRestaurante}](#POST-eventos/{eventoNombre}/restaurantes/{idRestaurante}})
    - [PUT eventos/{eventoNombre}/restaurante](#PUT-eventos/{eventoNombre}/restaurantes)
    - [DELETE eventos/{eventoNombre}/restaurante/{idRestaurante}](#DELETE-eventos/{eventoNombre}/restaurantes/{idRestaurante}])


### Recurso Compra
El objeto Compra tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    pagoConPuntos: '' /*Tipo Boolean*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    [
    producto: {
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    valorDinero: '' /*Tipo Integer*/, 
    valorPuntos: '' /*Tipo Integer*/}
    ],
    
    tarjetaPuntos: {
    id: '' /*Tipo Long*/,
    montoBasico: '' /*Tipo Integer*/,
    montoActual: '' /*Tipo Integer*/,
    numPuntos: '' /*Tipo Integer*/}
    
}
```



#### GET /compra

Retorna una colección de objetos Compra en representación Detail.
Cada Compra en la colección tiene embebidos los siguientes objetos: Producto, TarjetaPuntos.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-compra)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /compra/{id}

Retorna una colección de objetos Compra en representación Detail.
Cada Book en la colección tiene los siguientes objetos: Producto, TarjetaPuntos.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Compra a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Compra en [representaciones Detail](#recurso-book)
404|No existe un objeto Compra con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /compras

Es el encargado de crear objetos Compra.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Compra que será creado|Sí|[Representación Detail](#recurso-compra)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Compra ha sido creado|[Representación Detail](#recurso-book)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Book|Mensaje de error

#### PUT /compra/{id}

Es el encargado de actualizar objetos Compra.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Compra a actualizar|Sí|Integer
body|body|Objeto Compra nuevo|Sí|[Representación Detail](#recurso-compra)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Compra actualizado|[Representación Detail](#recurso-compra)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Compra|Mensaje de error

#### DELETE /compra/{id}

Elimina un objeto Compra.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Compra a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET compra/{comprasid}/productos

Retorna una colección de objetos Producto asociados a un objeto Compra en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Compra a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Producto en [representación Detail](#recurso-producto)
500|Error consultando authors |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET compra/{compraid}/producto/{productoid}

Retorna un objeto Producto asociados a un objeto Compra en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
booksid|Path|ID del objeto Compra a consultar|Sí|Integer
authorsid|Path|ID del objeto Producto a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Producto en [representación Detail](#recurso-producto)
404|No existe un objeto Producto con el ID solicitado asociado al objeto Book indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST compra/{compraid}/producto/{productoid}

Asocia un objeto Producto a un objeto Compra.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
booksid|PathParam|ID del objeto Compra al cual se asociará el objeto Author|Sí|Integer
authorsid|PathParam|ID del objeto Producto a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Producto asociado|[Representación Detail de Producto](#recurso-producto)
500|No se pudo asociar el objeto Producto|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT compra/{compraid}/producto

Es el encargado de remplazar la colección de objetos Producto asociada a un objeto Compra.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
booksid|Path|ID del objeto Compra cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Producto|Sí|[Representación Detail](#recurso-producto)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Author en [Representación Detail](#recurso-producto)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE compra/{compraid}/producto/{productoid}

Remueve un objeto Producto de la colección en un objeto Compra.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
booksid|Path|ID del objeto Compra asociado al objeto Producto|Sí|Integer
authorsid|Path|ID del objeto Producto a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso Administrador
El objeto Administrador tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    usuario: '' /*Tipo String*/,
    contrasena: '' /*Tipo String*/,
    
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    Restaurante:    [
        {  /* Restaurante  en su representación Minimum*/}
] 
    
}
```


#### GET /administradores

Retorna una colección de objetos Administrador en representación Detail.
Cada Administrador en la colección tiene embebidos los siguientes objetos: Restaurante.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-administrador)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /administradores/{administradoresid}

Retorna una colección de objetos Administrador en representación Detail.
Cada Administrador en la colección tiene los siguientes objetos: recargas, restaurante, tarjetasDePuntos, compras, comentarios.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Administrador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Administrador en [representaciones Detail](#recurso-administrador)
404|No existe un objeto Administrador con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /administradores

Es el encargado de crear objetos Administrador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Administrador que será creado|Sí|[Representación Detail](#recurso-administrador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Administrador ha sido creado|[Representación Detail](#recurso-administrador)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Administrador |Mensaje de error

#### PUT /administradores/{administradoresid}

Es el encargado de actualizar objetos Administrador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Administrador a actualizar|Sí|Integer
body|body|Objeto Administrador nuevo|Sí|[Representación Minimum](#recurso-administrador)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Administrador actualizado|[Representación Minimum](#recurso-administrador)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Administrador|Mensaje de error

#### DELETE /administradores/{administradoresid}

Elimina un objeto Administrador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Administrador a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET administradores/{administradoresid}/restaurante

Retorna una colección de objetos Restaurante asociados a un objeto Administrador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Administrador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Restaurante en [representación Detail](#recurso-Restaurante )
500|Error consultando restaurante |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET administradores/{administradoresid}/restaurante/{restauranteid}

Retorna un objeto Restaurante asociados a un objeto Administrador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
administradoresid|Path|ID del objeto Administradora consultar|Sí|Integer
restauranteid|Path|ID del objeto Restaurante a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Restaurante en [representación Detail](#recurso-Restaurante )
404|No existe un objeto Restaurante con el ID solicitado asociado al objeto Administrador indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST administradores/{administradoresid}/restaurante /{restauranteid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
administradoresid|PathParam|ID del objeto Administrador al cual se asociará el objeto Category|Sí|Integer
restauranteid|PathParam|ID del objeto Restaurante a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Restaurante asociado|[Representación Detail de Restaurante ](#recurso-Restaurante)
500|No se pudo asociar el objeto Restaurante |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT administradores/{administradoresid}/restaurante

Es el encargado de remplazar la colección de objetos Restaurante asociada a un objeto Administrador.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
administradoresid|Path|ID del objeto Administrador cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Restaurante |Sí|[Representación Detail](#recurso-restaurante)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Restaurante en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE administradores/{administradoresid}/restaurante /{restauranteid }

Remueve un objeto Restaurante de la colección en un objeto Administrador .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
administradoresid|Path|ID del objeto Administrador asociado al objeto Category|Sí|Integer
restauranteid |Path|ID del objeto Restaurante a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET administradores/{administradoresid}/tarjetasDePuntos

Retorna una colección de objetos TarjetaDePuntos asociados a un objeto Administrador en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Administrador a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos TarjetaDePuntos en [representación Detail](#recurso-tarjetaDePuntos )
500|Error consultando tarjetasDePuntos |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error


#### DELETE administradores/{administradoresid}/compras /{comprasid }

Remueve un objeto Compra de la colección en un objeto Administrador .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
administradoresid|Path|ID del objeto Administrador asociado al objeto Category|Sí|Integer
comprasid |Path|ID del objeto Compra a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso Restaurante
El objeto Restaurante tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    nit: '' /*Tipo String*/,
    nombre: '' /*Tipo String*/,
    tipoComida: '' /*Tipo String*/,
    
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    sucursales:    [
        {  /* Sucursal 1 en su representación Minimum*/}
         ...
        {  /* Sucursal n en su representación Minimum*/}
    ] 
productosCanjeables:     [
        {  /* Producto 1 en su representación Minimum*/}
         ...
        {  /* Producto n en su representación Minimum*/}
    ]
    
    eventos:     [
        {  /* Evento 1 en su representación Minimum*/}
         ...
        {  /* Evento n en su representación Minimum*/}
    ]
}
```



#### GET /restaurantes

Retorna una colección de objetos Restaurante en representación Detail.
Cada Restaurante en la colección tiene embebidos los siguientes objetos: Editorial.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-Restaurante)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /restaurantes/{restaurantesid}

Retorna una colección de objetos Restaurante en representación Detail.
Cada Restaurante en la colección tiene los siguientes objetos: productosCanjeables, sucursales, tarjetasDePuntos, eventos, comentarios.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Restaurante a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Restaurante en [representaciones Detail](#recurso-Restaurante)
404|No existe un objeto Restaurante con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /restaurantes

Es el encargado de crear objetos Restaurante.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Restaurante que será creado|Sí|[Representación Detail](#recurso-Restaurante)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Restaurante ha sido creado|[Representación Detail](#recurso-Restaurante)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Restaurante |Mensaje de error

#### PUT /restaurantes/{restaurantesid}

Es el encargado de actualizar objetos Restaurante.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Restaurante a actualizar|Sí|Integer
body|body|Objeto Restaurante nuevo|Sí|[Representación Minimum](#recurso-Restaurante)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Restaurante actualizado|[Representación Minimum](#recurso-Restaurante)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Restaurante|Mensaje de error

#### DELETE /restaurantes/{restaurantesid}

Elimina un objeto Restaurante.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Restaurante a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET restaurantes/{restaurantesid}/sucursales

Retorna una colección de objetos Sucursal asociados a un objeto Restaurante en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Restaurante a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Sucursal en [representación Detail](#recurso-Sucursal )
500|Error consultando sucursales |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET restaurantes/{restaurantesid}/sucursales/{sucursalesid}

Retorna un objeto Sucursal asociados a un objeto Restaurante en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurantea consultar|Sí|Integer
sucursalesid|Path|ID del objeto Sucursal a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Sucursal en [representación Detail](#recurso-Sucursal )
404|No existe un objeto Sucursal con el ID solicitado asociado al objeto Restaurante indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST restaurantes/{restaurantesid}/sucursales /{sucursalesid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|PathParam|ID del objeto Restaurante al cual se asociará el objeto Category|Sí|Integer
sucursalesid|PathParam|ID del objeto Sucursal a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Sucursal asociado|[Representación Detail de Sucursal ](#recurso-Sucursal)
500|No se pudo asociar el objeto Sucursal |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT restaurantes/{restaurantesid}/sucursales

Es el encargado de remplazar la colección de objetos Sucursal asociada a un objeto Restaurante.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurante cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Sucursal |Sí|[Representación Detail](#recurso-sucursales)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Sucursal en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE restaurantes/{restaurantesid}/sucursales /{sucursalesid }

Remueve un objeto Sucursal de la colección en un objeto Restaurante .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurante asociado al objeto Category|Sí|Integer
sucursalesid |Path|ID del objeto Sucursal a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error



#### GET restaurantes/{restaurantesid}/productosCanjeables

Retorna una colección de objetos Recarga asociados a un objeto Restaurante en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Restaurante a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Recarga en [representación Detail](#recurso-Recarga )
500|Error consultando productosCanjeables |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET restaurantes/{restaurantesid}/productosCanjeables/{productosCanjeablesid}

Retorna un objeto Recarga asociados a un objeto Restaurante en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurantea consultar|Sí|Integer
productosCanjeablesid|Path|ID del objeto Recarga a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Recarga en [representación Detail](#recurso-Recarga )
404|No existe un objeto Recarga con el ID solicitado asociado al objeto Restaurante indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST restaurantes/{restaurantesid}/productosCanjeables /{productosCanjeablesid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|PathParam|ID del objeto Restaurante al cual se asociará el objeto Category|Sí|Integer
productosCanjeablesid|PathParam|ID del objeto Recarga a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Recarga asociado|[Representación Detail de Recarga ](#recurso-Recarga)
500|No se pudo asociar el objeto Recarga |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT restaurantes/{restaurantesid}/productosCanjeables

Es el encargado de remplazar la colección de objetos Recarga asociada a un objeto Restaurante.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurante cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Recarga |Sí|[Representación Detail](#recurso-productosCanjeables)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Recarga en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE restaurantes/{restaurantesid}/productosCanjeables /{productosCanjeablesid }

Remueve un objeto Recarga de la colección en un objeto Restaurante .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurante asociado al objeto Category|Sí|Integer
productosCanjeablesid |Path|ID del objeto Recarga a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET restaurantes/{restaurantesid}/eventos

Retorna una colección de objetos Compra asociados a un objeto Restaurante en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Restaurante a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Compra en [representación Detail](#recurso-Compra )
500|Error consultando eventos |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET restaurantes/{restaurantesid}/eventos/{eventosid}

Retorna un objeto Compra asociados a un objeto Restaurante en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurantea consultar|Sí|Integer
eventosid|Path|ID del objeto Compra a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Compra en [representación Detail](#recurso-Compra )
404|No existe un objeto Compra con el ID solicitado asociado al objeto Restaurante indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST restaurantes/{restaurantesid}/eventos /{eventosid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|PathParam|ID del objeto Restaurante al cual se asociará el objeto Category|Sí|Integer
eventosid|PathParam|ID del objeto Compra a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Compra asociado|[Representación Detail de Compra ](#recurso-Compra)
500|No se pudo asociar el objeto Compra |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT restaurantes/{restaurantesid}/eventos

Es el encargado de remplazar la colección de objetos Compra asociada a un objeto Restaurante.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurante cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Compra |Sí|[Representación Detail](#recurso-eventos)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Compra en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE restaurantes/{restaurantesid}/eventos /{eventosid }

Remueve un objeto Compra de la colección en un objeto Restaurante .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
restaurantesid|Path|ID del objeto Restaurante asociado al objeto Category|Sí|Integer
eventosid |Path|ID del objeto Compra a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso Sucursal
El objeto Sucursal tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    nombre: '' /*Tipo String*/,
    descripcion: '' /*Tipo String*/,
    horaApertura: " /*Tipo LocalTime*/,
    horaCierre: " /*Tipo LocalTime*/,
    idRestaurante: '' /*Tipo Long*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    nombre: '' /*Tipo String*/,
    descripcion: '' /*Tipo String*/,
    horaApertura: " /*Tipo LocalTime*/,
    horaCierre: " /*Tipo LocalTime*/,
    idRestaurante: '' /*Tipo Long*/,
}
```



#### GET /sucursales

Retorna una colección de objetos Sucursal en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-sucursal)
412|precondition failed, no existe ninguna sucursal|Mensaje de error
500|Error interno|Mensaje de error

#### GET /sucursales/{id}

Retorna una colección de objetos Sucursal pertenecientes al restaurante con  el id dado

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del Objeto Sucursal buscado|Sí|Long

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Coleccion de objetos Sucursal en [representaciones Detail](#recurso-sucursal)
404|No existe ninguna sucursal con el id dado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /sucursales

Es el encargado de crear objetos Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Sucursal que será creado|Sí|[Representación Detail](#recurso-sucursal)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Sucursal ha sido creado|[Representación Detail](#recurso-Sucursal)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
500|No se pudo crear el objeto Sucursal|Mensaje de error

#### PUT /sucursal{id} 

Es el encargado de actualizar objetos Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sucursal a actualizar|Sí|Integer
body|body|Objeto Sucursal nuevo|Sí|[Representación Detail](#recurso-sucursal)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Sucursal actualizado|[Representación Detail](#recurso-Sucursal)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Sucursal|Mensaje de error

#### DELETE /sucursales/{id}
Elimina un objeto Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID de la sucursal a eliminar|Sí|Long

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
404|No existe la sucursal especificada|Mensaje de error

#### GET Sucursals/{id}/comentarios

Retorna una colección de objetos Comentario asociados a un objeto Sucursal en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sucursal a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Comentarioen [representación Detail](#recurso-comentario)
500|Error consultando categories |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET Sucursals/{id}/comentarios/{categoriesid}

Retorna un objeto Category asociados a un objeto Sucursal en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
Sucursalsid|Path|ID del objeto Sucursal a consultar|Sí|Integer
categoriesid|Path|ID del objeto Category a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Category en [representación Detail](#recurso-category)
404|No existe un objeto Category con el ID solicitado asociado al objeto Sucursal indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST Sucursals/{Sucursalsid}/categories/{categoriesid}

Asocia un objeto Category a un objeto Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
Sucursalsid|PathParam|ID del objeto Sucursal al cual se asociará el objeto Category|Sí|Integer
categoriesid|PathParam|ID del objeto Category a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Category asociado|[Representación Detail de Category](#recurso-category)
500|No se pudo asociar el objeto Category|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT Sucursals/{Sucursalsid}/categories

Es el encargado de remplazar la colección de objetos Category asociada a un objeto Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
Sucursalsid|Path|ID del objeto Sucursal cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Category|Sí|[Representación Detail](#recurso-category)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Category en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE sucursales/{id}/comentarios/{}

Remueve un objeto Category de la colección en un objeto Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sucursal asociado al objeto Category|Sí|Long
|Path|ID del objeto Comentario a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error

#### GET sucursales/{id}/compras

Retorna una colección de objetos Compra asociados a un objeto Sucursal en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sucursal a consultar|Sí|Long

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Compra en [representación Detail](#recurso-Compra)
500|Error consultando Compras |Mensaje de error

#### GET sucursales/{id}/compras/{idCompra}

Retorna un objeto Compra asociados a un objeto Sucursal en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sucursal a consultar|Sí|Long
idCompra|Path|ID del objeto Compra a consultar|Sí|Long

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Compra en [representación Detail](#recurso-Compra)
404|No existe un objeto Compra con el ID solicitado asociado al objeto Sucursal indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST sucursales/{id}/Compras/{Comprasid}

Asocia un objeto Compra a un objeto Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
Sucursalsid|PathParam|ID del objeto Sucursal al cual se asociará el objeto Compra|Sí|Integer
Comprasid|PathParam|ID del objeto Compra a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Compra asociado|[Representación Detail de Compra](#recurso-Compra)
500|No se pudo asociar el objeto Compra|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT sucursales/{id}/Compras

Es el encargado de remplazar la colección de objetos Compra asociada a un objeto Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sucursal cuya colección será remplazada|Sí|Long
body|body|Colección de objetos Compra|Sí|[Representación Detail](#recurso-Compra)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Compra en [Representación Detail](#recurso-Compra)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE sucursales/{id}/compras/{idCompra}

Remueve un objeto Compra de la colección en un objeto Sucursal.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Sucursal asociado al objeto Compra|Sí|Long
idCompra|Path|ID del objeto Compra a remover|Sí|Long

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error

### Recurso Producto
El objeto Producto tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    valorDinero: '' /*Tipo Integer*/, 
    valorPuntos: '' /*Tipo Integer*/
}
```
#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    restaurante: {
    id: '' /*Tipo Long*/,
    nit: '' /*Tipo String*/,
    nombre: '' /*Tipo String*/, 
    tipoComida: '' /*Tipo String*/}

}
```



#### GET /Producto

Retorna una colección de objetos Producto en representación Detail.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-producto)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /producto/{id}

Retorna una colección de objetos Producto en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Producto a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Producto en [representaciones Detail](#recurso-producto)
404|No existe un objeto Author con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /producto

Es el encargado de crear objetos Producto.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Producto que será creado|Sí|[Representación Detail](#recurso-producto)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Producto ha sido creado|[Representación Detail](#recurso-producto)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Author|Mensaje de error

#### PUT /producto/{id}

Es el encargado de actualizar objetos Producto.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Producto a actualizar|Sí|Integer
body|body|Objeto Producto nuevo|Sí|[Representación Detail](#recurso-producto)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Producto actualizado|[Representación Detail](#recurso-producto)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Producto|Mensaje de error

#### DELETE /producto/{id}

Elimina un objeto Producto.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Producto a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso Cliente
El objeto Cliente tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    usurario: '' /*Tipo String*/,
    nombre: '' /*Tipo String*/,
    contrasena: '' /*Tipo String*/,
    imagen: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    tarjetasDeCredito:    [
        {  /* TarjetaDeCredito 1 en su representación Minimum*/}
         ...
        {  /* TarjetaDeCredito n en su representación Minimum*/}
    ] 
    tarjetasDePuntos:    [
        {  /* TarjetaDePunto 1 en su representación Minimum*/}
         ...
        {  /* TarjetaDePunto n en su representación Minimum*/}
    ] 
    recargas:     [
        {  /* Recarga 1 en su representación Minimum*/}
         ...
        {  /* Recarga n en su representación Minimum*/}
    ]
    comentarios:     [
        {  /* Comentario 1 en su representación Minimum*/}
         ...
        {  /* Comentario n en su representación Minimum*/}
    ]
    compras:     [
        {  /* Compra 1 en su representación Minimum*/}
         ...
        {  /* Compra n en su representación Minimum*/}
    ]
}
```



#### GET /clientes

Retorna una colección de objetos Cliente en representación Detail.
Cada Cliente en la colección tiene embebidos los siguientes objetos: Editorial.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-cliente)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /clientes/{clientesid}

Retorna una colección de objetos Cliente en representación Detail.
Cada Cliente en la colección tiene los siguientes objetos: recargas, tarjetasDeCredito, tarjetasDePuntos, compras, comentarios.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Cliente en [representaciones Detail](#recurso-cliente)
404|No existe un objeto Cliente con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /clientes

Es el encargado de crear objetos Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Cliente que será creado|Sí|[Representación Detail](#recurso-cliente)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Cliente ha sido creado|[Representación Detail](#recurso-cliente)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Cliente |Mensaje de error

#### PUT /clientes/{clientesid}

Es el encargado de actualizar objetos Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a actualizar|Sí|Integer
body|body|Objeto Cliente nuevo|Sí|[Representación Minimum](#recurso-cliente)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Cliente actualizado|[Representación Minimum](#recurso-cliente)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Cliente|Mensaje de error

#### DELETE /clientes/{clientesid}

Elimina un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/tarjetasDeCredito

Retorna una colección de objetos TarjetaDeCredito asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos TarjetaDeCredito en [representación Detail](#recurso-tarjetaDeCredito )
500|Error consultando tarjetasDeCredito |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/tarjetasDeCredito/{tarjetasDeCreditoid}

Retorna un objeto TarjetaDeCredito asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Clientea consultar|Sí|Integer
tarjetasDeCreditoid|Path|ID del objeto TarjetaDeCredito a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto TarjetaDeCredito en [representación Detail](#recurso-tarjetaDeCredito )
404|No existe un objeto TarjetaDeCredito con el ID solicitado asociado al objeto Cliente indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST clientes/{clientesid}/tarjetasDeCredito /{tarjetasDeCreditoid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|PathParam|ID del objeto Cliente al cual se asociará el objeto Category|Sí|Integer
tarjetasDeCreditoid|PathParam|ID del objeto TarjetaDeCredito a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto TarjetaDeCredito asociado|[Representación Detail de TarjetaDeCredito ](#recurso-tarjetaDeCredito)
500|No se pudo asociar el objeto TarjetaDeCredito |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT clientes/{clientesid}/tarjetasDeCredito

Es el encargado de remplazar la colección de objetos TarjetaDeCredito asociada a un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos TarjetaDeCredito |Sí|[Representación Detail](#recurso-tarjetasDeCredito)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos TarjetaDeCredito en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE clientes/{clientesid}/tarjetasDeCredito /{tarjetasDeCreditoid }

Remueve un objeto TarjetaDeCredito de la colección en un objeto Cliente .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente asociado al objeto Category|Sí|Integer
tarjetasDeCreditoid |Path|ID del objeto TarjetaDeCredito a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/tarjetasDePuntos

Retorna una colección de objetos TarjetaDePuntos asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos TarjetaDePuntos en [representación Detail](#recurso-tarjetaDePuntos )
500|Error consultando tarjetasDePuntos |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/tarjetasDePuntos/{tarjetasDePuntosid}

Retorna un objeto TarjetaDePuntos asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Clientea consultar|Sí|Integer
tarjetasDePuntosid|Path|ID del objeto TarjetaDePuntos a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto TarjetaDePuntos en [representación Detail](#recurso-tarjetaDePuntos )
404|No existe un objeto TarjetaDePuntos con el ID solicitado asociado al objeto Cliente indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST clientes/{clientesid}/tarjetasDePuntos /{tarjetasDePuntosid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|PathParam|ID del objeto Cliente al cual se asociará el objeto Category|Sí|Integer
tarjetasDePuntosid|PathParam|ID del objeto TarjetaDePuntos a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto TarjetaDePuntos asociado|[Representación Detail de TarjetaDePuntos ](#recurso-tarjetaDePuntos)
500|No se pudo asociar el objeto TarjetaDePuntos |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT clientes/{clientesid}/tarjetasDePuntos

Es el encargado de remplazar la colección de objetos TarjetaDePuntos asociada a un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos TarjetaDePuntos |Sí|[Representación Detail](#recurso-tarjetasDePuntos)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos TarjetaDePuntos en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE clientes/{clientesid}/tarjetasDePuntos /{tarjetasDePuntosid }

Remueve un objeto TarjetaDePuntos de la colección en un objeto Cliente .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente asociado al objeto Category|Sí|Integer
tarjetasDePuntosid |Path|ID del objeto TarjetaDePuntos a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/comentarios

Retorna una colección de objetos Comentario asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Comentario en [representación Detail](#recurso-Comentario )
500|Error consultando comentarios |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/comentarios/{comentariosid}

Retorna un objeto Comentario asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Clientea consultar|Sí|Integer
comentariosid|Path|ID del objeto Comentario a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Comentario en [representación Detail](#recurso-Comentario )
404|No existe un objeto Comentario con el ID solicitado asociado al objeto Cliente indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST clientes/{clientesid}/comentarios /{comentariosid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|PathParam|ID del objeto Cliente al cual se asociará el objeto Category|Sí|Integer
comentariosid|PathParam|ID del objeto Comentario a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Comentario asociado|[Representación Detail de Comentario ](#recurso-Comentario)
500|No se pudo asociar el objeto Comentario |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT clientes/{clientesid}/comentarios

Es el encargado de remplazar la colección de objetos Comentario asociada a un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Comentario |Sí|[Representación Detail](#recurso-comentarios)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Comentario en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE clientes/{clientesid}/comentarios /{comentariosid }

Remueve un objeto Comentario de la colección en un objeto Cliente .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente asociado al objeto Category|Sí|Integer
comentariosid |Path|ID del objeto Comentario a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/recargas

Retorna una colección de objetos Recarga asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Recarga en [representación Detail](#recurso-Recarga )
500|Error consultando recargas |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/recargas/{recargasid}

Retorna un objeto Recarga asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Clientea consultar|Sí|Integer
recargasid|Path|ID del objeto Recarga a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Recarga en [representación Detail](#recurso-Recarga )
404|No existe un objeto Recarga con el ID solicitado asociado al objeto Cliente indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST clientes/{clientesid}/recargas /{recargasid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|PathParam|ID del objeto Cliente al cual se asociará el objeto Category|Sí|Integer
recargasid|PathParam|ID del objeto Recarga a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Recarga asociado|[Representación Detail de Recarga ](#recurso-Recarga)
500|No se pudo asociar el objeto Recarga |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT clientes/{clientesid}/recargas

Es el encargado de remplazar la colección de objetos Recarga asociada a un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Recarga |Sí|[Representación Detail](#recurso-recargas)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Recarga en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE clientes/{clientesid}/recargas /{recargasid }

Remueve un objeto Recarga de la colección en un objeto Cliente .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente asociado al objeto Category|Sí|Integer
recargasid |Path|ID del objeto Recarga a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/compras

Retorna una colección de objetos Compra asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Cliente a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Compra en [representación Detail](#recurso-Compra )
500|Error consultando compras |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### GET clientes/{clientesid}/compras/{comprasid}

Retorna un objeto Compra asociados a un objeto Cliente en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Clientea consultar|Sí|Integer
comprasid|Path|ID del objeto Compra a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Compra en [representación Detail](#recurso-Compra )
404|No existe un objeto Compra con el ID solicitado asociado al objeto Cliente indicado |Mensaje de error
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### POST clientes/{clientesid}/compras /{comprasid }

Asocia un objeto Category a un objeto Book.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|PathParam|ID del objeto Cliente al cual se asociará el objeto Category|Sí|Integer
comprasid|PathParam|ID del objeto Compra a asociar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Compra asociado|[Representación Detail de Compra ](#recurso-Compra)
500|No se pudo asociar el objeto Compra |Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT clientes/{clientesid}/compras

Es el encargado de remplazar la colección de objetos Compra asociada a un objeto Cliente.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente cuya colección será remplazada|Sí|Integer
body|body|Colección de objetos Compra |Sí|[Representación Detail](#recurso-compras)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos Compra en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### DELETE clientes/{clientesid}/compras /{comprasid }

Remueve un objeto Compra de la colección en un objeto Cliente .

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
clientesid|Path|ID del objeto Cliente asociado al objeto Category|Sí|Integer
comprasid |Path|ID del objeto Compra a remover|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error


### Recurso Recarga
El objeto Recarga tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    valor: '' /*Tipo Double*/,
    fecha: '' /*Tipo Date*/   
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    cliente:   {  /*Cliente en su representación Minimum*/}        
}
```



#### GET /recargas

Retorna una colección de objetos Recarga en representación Detail.
Cada Recarga en la colección tiene embebidos los siguientes objetos: Editorial.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-Recarga)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /recargas/{recargasid}

Retorna una colección de objetos Recarga en representación Detail.
Cada Recarga en la colección tiene los siguientes objetos: recargas, tarjetasDeCredito, clientes, compras, comentarios.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Recarga a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Recarga en [representaciones Detail](#recurso-Recarga)
404|No existe un objeto Recarga con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /recargas

Es el encargado de crear objetos Recarga.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Recarga que será creado|Sí|[Representación Detail](#recurso-Recarga)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Recarga ha sido creado|[Representación Detail](#recurso-Recarga)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto Recarga |Mensaje de error

#### PUT /recargas/{recargasid}

Es el encargado de actualizar objetos Recarga.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Recarga a actualizar|Sí|Integer
body|body|Objeto Recarga nuevo|Sí|[Representación Minimum](#recurso-Recarga)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Recarga actualizado|[Representación Minimum](#recurso-Recarga)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto Recarga|Mensaje de error

#### DELETE /recargas/{recargasid}

Elimina un objeto Recarga.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto Recarga a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso TarjetaDeCredito
El objeto TarjetaDeCredito tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    id: '' /*Tipo Long*/,
    numero: '' /*Tipo Long*/,
    banco: '' /*Tipo String*/
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.   
}
```



#### GET /tarjetasDeCredito

Retorna una colección de objetos TarjetaDeCredito en representación Detail.
Cada TarjetaDeCredito en la colección tiene embebidos los siguientes objetos: Editorial.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-TarjetaDeCredito)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### GET /tarjetasDeCredito/{tarjetasDeCreditoid}

Retorna una colección de objetos TarjetaDeCredito en representación Detail.
Cada TarjetaDeCredito en la colección tiene los siguientes objetos: recargas, tarjetasDeCredito, tarjetasDePuntos, compras, comentarios.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto TarjetaDeCredito a consultar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto TarjetaDeCredito en [representaciones Detail](#recurso-TarjetaDeCredito)
404|No existe un objeto TarjetaDeCredito con el ID solicitado|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|Error interno|Mensaje de error

#### POST /tarjetasDeCredito

Es el encargado de crear objetos TarjetaDeCredito.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto TarjetaDeCredito que será creado|Sí|[Representación Detail](#recurso-TarjetaDeCredito)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto TarjetaDeCredito ha sido creado|[Representación Detail](#recurso-TarjetaDeCredito)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo crear el objeto TarjetaDeCredito |Mensaje de error

#### PUT /tarjetasDeCredito/{tarjetasDeCreditoid}

Es el encargado de actualizar objetos TarjetaDeCredito.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto TarjetaDeCredito a actualizar|Sí|Integer
body|body|Objeto TarjetaDeCredito nuevo|Sí|[Representación Minimum](#recurso-TarjetaDeCredito)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto TarjetaDeCredito actualizado|[Representación Minimum](#recurso-TarjetaDeCredito)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error
500|No se pudo actualizar el objeto TarjetaDeCredito|Mensaje de error

#### DELETE /tarjetasDeCredito/{tarjetasDeCreditoid}

Elimina un objeto TarjetaDeCredito.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
id|Path|ID del objeto TarjetaDeCredito a eliminar|Sí|Integer

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

### Recurso Evento
El objeto Evento tiene 2 representaciones JSON:	

#### Representación Minimum
```javascript
{
    nombre: '' /*Tipo String*/,
    fechaInicio: "/*Tipo Calendar*/,
    fechaFin: "/*Tipo Calendar*/,
    descripcion: '' /*Tipo String*/,
}
```

#### Representación Detail
```javascript
{
    // todo lo de la representación Minimum más los objetos Minimum con relación simple.
    nombre: '' /*Tipo String*/,
    fechaInicio: "/*Tipo Calendar*/,
    fechaFin: "/*Tipo Calendar*/,
    descripcion: '' /*Tipo String*/,
   
}
```



#### GET /eventos

Retorna una colección de objetos Evento en representación Detail.
Cada Evento en la colección tiene embebidos los siguientes objetos: Editorial.

#### Parámetros

#### N/A

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de [representaciones Detail](#recurso-Evento)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
500|Error interno|Mensaje de error

#### GET /eventos/{nombre}

Retorna una colección de objetos Evento en representación Detail.
Cada Evento en la colección tiene los siguientes objetos: Editorial.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Evento en [representaciones Detail](#recurso-Evento)
404|No existe un objeto Evento con el ID solicitado|Mensaje de error
500|Error interno|Mensaje de error

#### POST /eventos

Es el encargado de crear objetos Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
body|body|Objeto Evento que será creado|Sí|[Representación Detail](#recurso-Evento)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Evento ha sido creado|[Representación Detail](#recurso-Evento)
412|precondition failed, no se cumple la regla de negocio establecida|Mensaje de error
500|No se pudo crear el objeto Evento|Mensaje de error

#### PUT /eventos/{nombre}

Es el encargado de actualizar objetos Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|nombre del Evento a actualizar|Sí|String
body|body|Objeto Evento nuevo|Sí|[Representación Detail](#recurso-Evento)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
201|El objeto Evento actualizado|[Representación Detail](#recurso-Evento)
412|business exception, no se cumple con las reglas de negocio|Mensaje de error
500|No se pudo actualizar el objeto Evento|Mensaje de error

#### DELETE /eventos/{nombre}

Elimina un objeto Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
Nobre|Path|Nombre del Evento a eliminar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto eliminado|N/A
500|Error interno|Mensaje de error

#### GET eventos/{nombre}/ubicaciones

Retorna una colección de objetos Ubicacion asociados a un objeto Evento en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Category en [representación Detail](#recurso-category)
500|Error consultando categories |Mensaje de error

#### GET eventos/{nombre}/ubicaciones/{direccion}

Retorna un objeto Ubicacion asociados a un objeto Evento en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String
direccion|Path|Direccion del objeto Ubicacion a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Objeto Category en [representación Detail](#recurso-category)
404|No existe un objeto Category con el ID solicitado asociado al objeto Evento indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST eventos/{nombre}/ubicaciones/{direccion}

Asocia un objeto Ubicacion a un objeto Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String
direccion|Path|Direccion del objeto Ubicacion a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Ubicacion asociado|[Representación Detail de Ubicacion](#recurso-ubicacion)
500|No se pudo asociar el objeto Ubicacion|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT eventos/{nombre}/ubicaciones

Es el encargado de remplazar la colección de objetos Ubicacion asociada a un objeto Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del objeto Evento cuya colección será remplazada|Sí|String
body|body|Colección de objetos Ubicacion|Sí|[Representación Detail](#recurso-Ubicacion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objeto Ubicacion en [Representación Detail](#recurso-ubicacion)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE eventos/{nombre}/ubicaciones/{direccion}

Remueve un objeto Ubicacion de la colección en un objeto Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String
direccion|Path|Direccion del objeto Ubicacion a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error

#### GET eventos/{nombre}/restaurantes

Retorna una colección de objetos Restaurante asociados a un objeto Evento en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|Colección de objetos Category en [representación Detail](#recurso-restaurante)
500|Error consultando categories |Mensaje de error

#### GET eventos/{nombre}/restaurantes/{id}

Retorna un objeto Restaurante asociados a un objeto Evento en representación Detail.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String
direccion|Path|Direccion del objeto Ubicacion a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|OK|ObjetoRestaurante en [representación Detail](#recurso-restaurante)
404|No existe un objeto Restaurante con el ID solicitado asociado al objeto Evento indicado |Mensaje de error
500|Error interno|Mensaje de error

#### POST eventos/{nombre}/restaurantes/{id}

Asocia un objeto Restaurante a un objeto Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String
id|Path|Id del objeto Restaurante a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Objeto Restaurante asociado|[Representación Detail de Restaurante](#recurso-restaurante)
500|No se pudo asociar el objeto Restaurante|Mensaje de error
405|method not allowed, no existe permiso para el recurso|Mensaje de error

#### PUT eventos/{nombre}/restaurantes

Es el encargado de remplazar la colección de objetos Ubicacion asociada a un objeto Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del objeto Evento cuya colección será remplazada|Sí|String
body|body|Colección de objetos Ubicacion|Sí|[Representación Detail](#recurso-Ubicacion)

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
200|Se remplazó la colección|Colección de objetos restaurante en [Representación Detail](#recurso-category)
500|No se pudo remplazar la colección|Mensaje de error

#### DELETE eventos/{nombre}/restaurante/{id}

Remueve un objeto Restaurante de la colección en un objeto Evento.

#### Parámetros

Nombre|Ubicación|Descripción|Requerido|Esquema
:--|:--|:--|:--|:--
nombre|Path|Nombre del Evento a consultar|Sí|String
id|Path|Id del objeto Restaurante a consultar|Sí|String

#### Respuesta

Código|Descripción|Cuerpo
:--|:--|:--
204|Objeto removido|N/A
500|Error interno|Mensaje de error


