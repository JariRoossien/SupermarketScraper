# API Explanations

Each API has their own endpoints, and provides the data of a product according 
to what their needs are. This means the structure will always be unique, and
some information might be hidden behind a second call.

## AH
AH uses a search API with the following URL.

``https://www.ah.nl/zoeken/api/products/search``

It contains some options like these:

- **query:** Search field
- **size:** Amount to return, by default 23, Max size 1000
- **page:**

### Response

```json
{
  "cards": [
    {
      "type": "default",
      "id": 526385,
      "products": [
        {
          "id": 526385,
          "control": {
            "theme": "ah",
            "type": "default"
          },
          "title": "Lay's Naturel",
          "link": "/producten/product/wi526385/lay-s-naturel",
          "availableOnline": true,
          "orderable": true,
          "highlight": {
            "name": "nutriscore-c"
          },
          "propertyIcons": [
            {
              "name": "vegan-color",
              "title": "Vegan"
            }
          ],
          "images": [
            {
              "height": 200,
              "width": 200,
              "title": "Lay's Naturel",
              "url": "https://static.ah.nl/dam/product/AHI_43545239393030373237?revLabel=3&rendition=200x200_JPG_Q85&fileType=binary",
              "ratio": "1-1"
            },
            ...
          ],
          "price": {
            "unitInfo": {
              "price": 8.3,
              "description": "KG"
            },
            "now": 2.49,
            "unitSize": "300 g"
          },
          "itemCatalogId": 603158,
          "brand": "Lay's",
          "category": "Snoep, koek, chips en chocolade/Naturel chips",
          "theme": "ah",
          "hqId": 30920,
          "gtins": [
            8710398526694,
            8710398526410
          ],
          "summary": "",
          "descriptionFull": "",
          "taxonomyId": 1908,
          "taxonomies": [
            {
              "id": 1555,
              "name": "Snoep, koek, chips en chocolade",
              "imageSiteTarget": "app_cat_snoep_koek_chips",
              "images": [],
              "shown": true,
              "level": 1,
              "sortSequence": 8,
              "parentIds": [
                0
              ]
            },
            ...
          ],
          "contributionMargin": 0,
          "properties": {
            "nutriscore": "C",
            "lifestyle": [
              "zonder_melk",
              ...
            ]
          }
        }
      ]
    }
  ],
  "page": {
    "size": 1,
    "totalElements": 16,
    "totalPages": 16,
    "number": 0
  },
  "aggregation": {
    "properties": [
      {
        "id": "bonus",
        "label": "Bonus",
        "count": 2
      },
      ...
    ],
    "brands": [
      {
        "name": "Lay's",
        "count": 15,
        "id": "Lay's",
        "label": "Lay's"
      },
      ...
    ],
    "taxonomies": [
      {
        "count": 3,
        "id": 2213,
        "shown": true,
        "level": 3,
        "parentIds": [
          997
        ],
        "rank": 0,
        "relevant": true,
        "label": "Chips met een vormpje"
      },
      ...
    ],
    "prices": [
      {
        "count": 16,
        "min": 0.66,
        "max": 26.58,
        "label": "*-*"
      }
    ]
  },
  "taxonomies": [],
  "querySuggestions": []
}
```

## Dekamarkt

Dekamarkt has an API from their website

``https://api.dekamarkt.nl/v1/assortmentcache/search/283/?``

It has the following options:

- **search**: The search term
- **api_key**: Each request requires a UUID API key.
- **limit**: Default is set to 500, does not have an upper limit.

### Response

```json
[
  {
    "ProductID": 5053,
    "ProductNumber": "329908",
    "MainDescription": "Ontbijtkoek XL",
    "SubDescription": null,
    "CommercialContent": "600 g",
    "MaxPerCustomer": null,
    "DepositMoney": null,
    "Brand": "Bolletje",
    "ProductOnline": true,
    "ProductInStock": false,
    "WeightArticle": false,
    "ScaleIndicator": false,
    "PiecesInWeight": null,
    "AlcoholPercentage": null,
    "TemporaryNotAvailable": false,
    "PublicationAfter": null,
    "WeightOfPeicesInWeight": null,
    "ProductPicture": {
      "Url": "https://d3r3h30p75xj6a.cloudfront.net/artikelen/95882_1_329908_637867368853916172.png",
      "IsPrimary": true
    },
    "Logos": [],
    "ProductPrices": [
      {
        "PriceID": 733016525,
        "StoreID": 283,
        "ProductID": 5053,
        "Price": 2.19,
        "RegularPrice": 2.19,
        "PricePerKilo": null,
        "PricePerDefaultUnit": 3.65,
        "DefaultUnit": "1 KG",
        "IsActionPrice": false,
        "TaxID": 1,
        "StartDate": "2023-03-20T00:00:00",
        "EndDate": "2049-12-31T23:59:59",
        "PriceLineCode": 100
      }
    ],
    "WebSubGroups": [
      {
        "WebSubGroupID": 118,
        "Position": 1,
        "Description": "Naturel ontbijtkoek",
        "WebGroup": {
          "WebGroupID": 25,
          "Position": 8,
          "Description": "Ontbijtkoek",
          "WebDepartment": {
            "WebDepartmentID": 3,
            "Position": 3,
            "Description": "Brood, beleg & koek"
          }
        }
      }
    ],
    "ProductOffers": [],
    "StoreAssortments": [],
    "IsSingleUsePlastic": false
  }
]
```

### Dekamarkt Product API

Dekamarkt also has a specific API call for each product, this contains more information like the 
bar code of a specific product.

### query
``https://api.dekamarkt.nl/v1/assortmentcache/number/283/<PRODUCT_ID>``

Options:
- **api_key**


### response
```json
{
  "ProductID": 58243,
  "CreatedAt": "2020-02-06T04:12:13.63",
  "ModifiedAt": "2023-08-04T15:44:03.2",
  "Number": "248081",
  "MainDescription": "Basilicum",
  "SubDescription": "grote pot",
  "ExtraDescription": null,
  "CommercialContent": "Per stuk",
  "CommodityLawName": null,
  "MinimumAge": null,
  "AlcoholPercentage": null,
  "Durability": null,
  "ScaleIndicator": false,
  "WeightArticle": false,
  "DepositMoney": null,
  "TaxID": 1,
  "OwnBrand": false,
  "TemporaryNotAvailable": false,
  "ProductOnline": true,
  "ContentCE": 1,
  "CodeContentCE": 4,
  "UnitContentCE": "ST",
  "PiecesInWeight": null,
  "WeightOfPeicesInWeight": null,
  "Biological": false,
  "MinTemperature": null,
  "MaxTemperature": null,
  "FromPersons": null,
  "ToPersons": null,
  "Brand": null,
  "MaxPerCustomer": null,
  "Location": null,
  "PublicationAfter": null,
  "ProductOffers": [],
  "ProductDeclarations": [],
  "ProductBarcodes": [
    {
      "Barcode": "8172858450039"
    },
    {
      "Barcode": "8718858450039"
    },
    {
      "Barcode": "22480811"
    }
  ],
  "Tax": {
    "TaxID": 1,
    "Description": "9%",
    "Percentage": 9
  },
  "BrandInfo": null,
  "ProductPictures": [
    {
      "Url": "https://d3r3h30p75xj6a.cloudfront.net/artikelen/69184_1_248081_637759531309537761.png",
      "IsPrimary": true
    },
    {
      "Url": "https://d3r3h30p75xj6a.cloudfront.net/artikelen/69185_1_248081_637759531324242919.png",
      "IsPrimary": false
    }
  ],
  "ProductPrices": [
    {
      "PriceID": 804153696,
      "StoreID": 283,
      "ProductID": 58243,
      "Price": 1.89,
      "RegularPrice": 1.89,
      "PricePerKilo": null,
      "PricePerDefaultUnit": 1.89,
      "DefaultUnit": "1 ST",
      "IsActionPrice": false,
      "TaxID": 1,
      "StartDate": "2023-06-18T00:00:00",
      "EndDate": "2049-12-31T23:59:59",
      "PriceLineCode": 100
    }
  ],
  "Logos": [
    {
      "LogoID": 646641,
      "Description": "Planet proof",
      "Url": "https://d3r3h30p75xj6a.cloudfront.net/logos/Planet_proef.png",
      "Position": 99,
      "Info": null,
      "IsDirk": true,
      "IsDeka": true
    }
  ],
  "WebSubGroups": [
    {
      "WebSubGroupID": 680,
      "Position": 6,
      "Description": "Verse kruiden",
      "WebGroup": {
        "WebGroupID": 4,
        "Position": 16,
        "Description": "Sla & verse kruiden",
        "WebDepartment": {
          "WebDepartmentID": 1,
          "Position": 1,
          "Description": "Aardappelen, groente & fruit"
        }
      }
    }
  ],
  "Nutrition": [],
  "SubGroup": {
    "SubGroupID": 1155,
    "ExcludeFromPaas": false,
    "Description": "KRUIDEN",
    "Hoofdgroepen": null
  },
  "IsSingleUsePlastic": false
}
```

## Vomar

Vomar's endpoint is quite simple

### Endpoint
``https://api.vomar.nl/api/v1/article/search``

Options:
- **searchString** - Must contain at least 1 non-whitespace token

There's no limits.

### Response

```json
[
  {
    "articleNumber": 106904,
    "description": "LAY'S CHIPS NATUREL 300GR",
    "detailedDescription": "Lay's Naturel Chips 300 gr",
    "departmentNumberWebsite": 55,
    "mainGroupNumberWebsite": 553,
    "subGroupNumberWebsite": 11,
    "eanPrimary": "8710398526694",
    "price": 2.35,
    "priceDefaultAmount": 7.8333333333,
    "images": [
      {
        "shotTypeId": 1,
        "shotType": "ID-opname",
        "imageUrl": "Lay-s-Naturel-Chips-300-gr-8710398526694-1-638272584113198213.png"
      }
    ],
    "brand": "Lay's",
    "consumentengewicht": 0,
    "relevancy": 35,
    "discountDeal": false
  }
  ...
]
```

## Jumbo

Jumbo's API has been retrieved from their Mobile application.

### Endpoint
```https://mobileapi.jumbo.com/v17/search```

Options:
- **q** - Can be empty
- **limit** - Max 30.
- **offset** - Required to get more than 30 elements.

### Response

```json
{
  "products": {
    "data": [
      {
        "id": "535661ZK",
        "title": "Lay's Naturel Chips 300gr",
        "quantityOptions": [
          {
            "defaultAmount": 1,
            "minimumAmount": 1,
            "amountStep": 1,
            "unit": "pieces",
            "maximumAmount": 99
          }
        ],
        "available": true,
        "productType": "Product",
        "crossSellSKUList": [],
        "nixProduct": false,
        "quantity": "300 Gram",
        "imageInfo": {
          "primaryView": [
            {
              "url": "https://jumbo.com/dam-images/fit-in/360x360/Products/09012024_1704773129212_1704773147628_535661_ZK_08710398526694_C1N1.png",
              "height": 360,
              "width": 360
            }
          ]
        },
        "prices": {
          "price": {
            "currency": "EUR",
            "amount": 219
          },
          "unitPrice": {
            "unit": "kg",
            "price": {
              "currency": "EUR",
              "amount": 730
            }
          }
        },
        "badgesToDisplay": {},
        "sample": false,
        "availability": {
          "sku": "535661ZK",
          "availability": "AVAILABLE"
        },
        "surcharges": []
      }
    ],
    "total": 66,
    "offset": 0
  },
  ...
}
```

### Where to find GTIN / EAN

We take the URL ``"url": "https://jumbo.com/dam-images/fit-in/360x360/Products/09012024_1704773129212_1704773147628_535661_ZK_08710398526694_C1N1.png"``, and the last digits before
C1N1.png or _1.png is the EAN / GTIN, in this case (0)8710398526694


## Coop

Coop has one of the most extensive API's so far.

### URL

```https://api.coop.nl/INTERSHOP/rest/WFS/COOP-COOPBase-Site/-;loc=nl_NL;cur=EUR/culios/products?searchTerm=lays&amount=20&attrs=sku,salePrice,listPrice,availability,manufacturer,image,minOrderQuantity,inStock,promotions,packingUnit,mastered,productMaster,productMasterSKU,roundedAverageRating,longtail,sticker,maxXLabel,Inhoud,SUPprice&attributeGroup=PRODUCT_LIST_DETAIL_ATTRIBUTES&productFilter=fallback_searchquerydefinition&offset=0&_date=2024-01-20```

### Response
```json
{
  "type": "CuliosProductsContainerRO",
  "searchID": "252166786",
  "offset": 0,
  "amount": 20,
  "total": 52,
  "filters": [
    ...
  ],
  "elements": [
    {
      "name": "Lay's Naturel Chips",
      "type": "Product",
      "attributes": [
        {
          "name": "Inhoud",
          "type": "String",
          "value": "200 g"
        },
        {
          "name": "longtail",
          "type": "Boolean",
          "value": false
        }
      ],
      "sku": "8710398526014",
      "productName": "Lay's Naturel Chips",
      "shortDescription": "Lay's Naturel Chips",
      "longDescription": "De vertrouwde smaak van Lay's® Naturel, tot perfectie gebakken. Lay's® chips zijn verkrijgbaar in veel lekkere varianten, allemaal barstensvol smaak!",
      "availability": true,
      "retailSet": false,
      "inStock": true,
      "productMaster": false,
      "mastered": false,
      "readyForShipmentMin": 3,
      "readyForShipmentMax": 7,
      "minOrderQuantity": 1,
      "productBundle": false,
      "manufacturer": "PepsiCo Nederland B.V.",
      "listPrice": {
        "type": "ProductPrice",
        "value": 1.98,
        "currencyMnemonic": "EUR",
        "currency": "EUR"
      },
      "salePrice": {
        "type": "ProductPrice",
        "value": 1.98,
        "currencyMnemonic": "EUR",
        "currency": "EUR"
      },
      "maxOrderQuantity": 99,
      "stepOrderQuantity": 1,
      "packingUnit": "pcs",
      "images": [
        {
          "name": "standaard 670x670",
          "type": "Image",
          "effectiveUrl": "https://syndy-content.azureedge.net/media/products/21c50000-ff27-0003-1d5d-08da7c68cd4d/images/AW0HA3GItENDpZ-NPK0ohvI./AAMMVEU6DQAuKgjb_wwegw.670x670.png",
          "viewID": "standaard",
          "typeID": "670x670",
          "imageActualHeight": 670,
          "imageActualWidth": 670,
          "primaryImage": true
        },
        {
          "name": "standaard 270x270",
          "type": "Image",
          "effectiveUrl": "https://syndy-content.azureedge.net/media/products/21c50000-ff27-0003-1d5d-08da7c68cd4d/images/AW0HA3GItENDpZ-NPK0ohvI./AAMMVEU6DQAuKgjb_wwegw.270x270.png",
          "viewID": "standaard",
          "typeID": "270x270",
          "imageActualHeight": 270,
          "imageActualWidth": 270,
          "primaryImage": true
        },
        ...
      ],
      "defaultCategory": {
        "name": "Naturel chips",
        "type": "DefaultCategory",
        "id": "naturel_chips",
        "categoryPath": [
          {
            "name": "Boodschappen",
            "type": "CategoryPath",
            "id": "boodschappen",
            "uri": "COOP-COOPBase-Site/-;loc=nl_NL;cur=EUR/categories/boodschappen"
          },
          {
            "name": "Chips, nootjes en borrelhapjes",
            "type": "CategoryPath",
            "id": "chips_nootjes_en_borrelhapjes",
            "uri": "COOP-COOPBase-Site/-;loc=nl_NL;cur=EUR/categories/chips_nootjes_en_borrelhapjes"
          },
          ...
        ],
        "uri": "COOP-COOPBase-Site/-;loc=nl_NL;cur=EUR/categories/naturel_chips"
      },
      "attributeGroups": {},
      "supplierSKU": ""
    },
...
}
```
