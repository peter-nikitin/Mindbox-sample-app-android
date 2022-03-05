package cloud.mindbox.mobile_sdk

import android.content.Context
import cloud.mindbox.mobile_sdk.models.operation.CustomFields
import cloud.mindbox.mobile_sdk.models.operation.DateOnly
import cloud.mindbox.mobile_sdk.models.operation.Ids
import cloud.mindbox.mobile_sdk.models.operation.Sex
import cloud.mindbox.mobile_sdk.models.operation.request.*
import java.util.*


class BasicOperations {
    private lateinit var context: Context

    fun authorizeCustomer() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.AuthorizeCustomer",
            operationBody = OperationBodyRequest(
                customer = CustomerRequest(
                    ids = Ids(
                        "website" to "myAwesomeWebsiteId"
                    ),
                    discountCard = DiscountCardRequest(
                        ids = Ids("number" to "123")
                    ),
                    birthDate = DateOnly(),
                    sex = Sex.FEMALE,
                    timeZone = TimeZone.getDefault(),
                    lastName = "<Фамилия>",
                    firstName = "<Имя>",
                    middleName = "<Отчество>",
                    area = AreaRequest(
                        Ids(
                            "externalId" to "<Внешний идентификатор зоны>"
                        )
                    ),
                    email = "<Email>",
                    mobilePhone = "<Мобильный телефон>",
                    customFields = CustomFields(
                        "<Имя доп поля 1>" to "<Значение доп поля>",
                        "<Имя доп поля 2>" to arrayListOf(
                            "<Значение доп поля>",
                            "<Значение доп поля>"
                        ),
                    ),
                    subscriptions = arrayListOf(
                        SubscriptionRequest(
                            brand = "<Системное имя бренда подписки клиента>",
                            pointOfContact = PointOfContactRequest.EMAIL,
                            topic = "<Внешний идентификатор тематики подписки>",
                            isSubscribed = true
                        )
                    )
                )
            )
        )
    }

    fun registerCustomer() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.RegisterCustomer",
            operationBody = OperationBodyRequest(
                customer = CustomerRequest(
                    ids = Ids(
                        "website" to "myAwesomeWebsiteId"
                    ),
                    discountCard = DiscountCardRequest(
                        ids = Ids("number" to "123")
                    ),
                    birthDate = DateOnly(),
                    sex = Sex.FEMALE,
                    timeZone = TimeZone.getDefault(),
                    lastName = "<Фамилия>",
                    firstName = "<Имя>",
                    middleName = "<Отчество>",
                    area = AreaRequest(
                        Ids(
                            "externalId" to "<Внешний идентификатор зоны>"
                        )
                    ),
                    email = "<Email>",
                    mobilePhone = "<Мобильный телефон>",
                    customFields = CustomFields(
                        "<Имя доп поля 1>" to "<Значение доп поля>",
                        "<Имя доп поля 2>" to arrayListOf(
                            "<Значение доп поля>",
                            "<Значение доп поля>"
                        ),
                    ),
                    subscriptions = arrayListOf(
                        SubscriptionRequest(
                            brand = "<Системное имя бренда подписки клиента>",
                            pointOfContact = PointOfContactRequest.EMAIL,
                            topic = "<Внешний идентификатор тематики подписки>",
                            isSubscribed = true
                        )
                    )

                )

            )
        )
    }

    fun viewProduct() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.ViewProduct",
            operationBody = OperationBodyRequest(
                viewProductRequest = ViewProductRequest(
                    product = ProductRequest(
                        ids = Ids(
                            "website" to "<Id product в Website>"
                        )
                    )
                )
            )
        )
    }

    fun viewProductGroup() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.ViewProduct",
            operationBody = OperationBodyRequest(
                viewProductRequest = ViewProductRequest(
                    productGroup = ProductGroupRequest(
                        Ids(
                            "website" to "<Id product в Website>"
                        )
                    )
                )
            )
        )
    }

    fun viewProductCategory() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.ViewCategory",
            operationBody = OperationBodyRequest(
                viewProductCategory = ViewProductCategoryRequest(
                    productCategory = ProductCategoryRequest(
                        Ids(
                            "website" to "<Id Product Category в Website>"
                        )
                    )
                )
            )
        )
    }

    fun clearCart() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.ClearCart",
            operationBody = OperationBodyRequest()
        )
    }

    fun setCart() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.ClearCart",
            operationBody = OperationBodyRequest(
                productList = arrayListOf(
                    ProductListItemRequest(
                        count = 2.0, // <Количество продуктов>
                        product = ProductRequest(
                            Ids(
                                "website" to "<Id Product в Website>"
                            )
                        ),
                        isPricePerItem = false, // если передается цена за единицу товара
                        price = 10.0
                    ),
                    ProductListItemRequest(
                        count = 2.0, // <Количество продуктов>
                        product = ProductRequest(
                            Ids(
                                "website" to "<Id Product в Website>"
                            )
                        ),
                        isPricePerItem = true, // если передается цена за линицю в корзине
                        price = 10.0
                    ),
                    ProductListItemRequest(
                        count = 2.0, // <Количество продуктов>
                        productGroup = ProductGroupRequest(
                            Ids(
                                "website" to "<Id Product в Website>"
                            )
                        ),
                        isPricePerItem = true, // если передается цена за линицю в корзине
                        price = 10.0
                    ),
                )
            )
        )
    }

    fun removeProductFromWishList() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.RemoveFromWishList",
            operationBody = OperationBodyRequest(
                removeProductFromList = ProductListItemRequest(
                    product = ProductRequest(
                        Ids(
                            "website" to "<Id Product в Website>"
                        )
                    ),
                    pricePerItem = 10.0

                )
            )
        )
    }

    fun removeProductGroupFromWishList() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.RemoveFromWishList",
            operationBody = OperationBodyRequest(
                removeProductFromList = ProductListItemRequest(
                    productGroup = ProductGroupRequest(
                        Ids(
                            "website" to "<Id Product в Website>"
                        )
                    ),
                    pricePerItem = 10.0

                )
            )
        )
    }

    fun setCountProductGroupInWishList() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.SetCountWishList",
            operationBody = OperationBodyRequest(
                setProductCountInList = ProductListItemRequest(
                    productGroup = ProductGroupRequest(
                        Ids(
                            "website" to "<Id Product в Website>"
                        )
                    ),
                    pricePerItem = 10.0 //priceOfLine, для передачи стомости линии
                )
            )
        )
    }

    fun setCountProductInWishList() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.SetCountWishList",
            operationBody = OperationBodyRequest(
                setProductCountInList = ProductListItemRequest(
                    product = ProductRequest(
                        Ids(
                            "website" to "<Id Product в Website>"
                        )
                    ),
                    pricePerItem = 10.0 //priceOfLine, для передачи стомости линии
                )
            )
        )
    }


    fun createAuthorizedOrder() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.CreateAuthorizedOrder",
            operationBody = OperationBodyRequest(
                customer = CustomerRequest(
                    ids = Ids(
                        "website" to "myAwesomeWebsiteId"
                    ),
                    discountCard = DiscountCardRequest(
                        Ids(
                            "number" to "123"
                        )
                    ),
                    birthDate = DateOnly(),
                    sex = Sex.FEMALE,
                    timeZone = TimeZone.getDefault(),
                    lastName = "<Фамилия>",
                    firstName = "<Имя>",
                    middleName = "<Отчество>",
                    area = AreaRequest(
                        Ids(
                            "externalId" to "<Внешний идентификатор зоны>"
                        )
                    ),
                    email = "<Email>",
                    mobilePhone = "<Мобильный телефон>",
                    customFields = CustomFields(
                        "<Имя доп поля 1>" to "<Значение доп поля>",
                        "<Имя доп поля 2>" to arrayListOf(
                            "<Значение доп поля>",
                            "<Значение доп поля>"
                        ),
                    ),
                    subscriptions = arrayListOf(
                        SubscriptionRequest(
                            brand = "<Системное имя бренда подписки клиента>",
                            pointOfContact = PointOfContactRequest.EMAIL,
                            topic = "<Внешний идентификатор тематики подписки>",
                            isSubscribed = true
                        )
                    )
                ),
                order = OrderRequest(
                    ids = Ids(
                        "websiteId" to "<Идентификатор заказа Идентификатор на сайте>"
                    ),
                    cashdesk = CashdeskRequest(
                        Ids(
                            "websiteId" to "<Идентификатор заказа Идентификатор на сайте>"
                        )
                    ),
                    deliveryCost = 100.0,
                    customFields = CustomFields(
                        "<Имя доп поля 1>" to "<Значение доп поля>",
                        "<Имя доп поля 2>" to arrayListOf(
                            "<Значение доп поля>",
                            "<Значение доп поля>"
                        ),
                    ),
                    area = AreaRequest(
                        Ids(
                            "externalId" to "<Внешний идентификатор зоны>"
                        )
                    ),
                    totalPrice = 100.0,
                    discounts = arrayListOf(
                        DiscountRequest(
                            promoCode = PromoCodeRequest(
                                ids = Ids(
                                    "code" to "<Идентификатор промокода>"
                                )
                            ),
                            amount = 100.0
                        ),
                        DiscountRequest(
                            externalPromoAction = ExternalPromoActionRequest(
                                Ids(
                                    "externalId" to "<Идентификатор промоакции>"
                                ),
                            ),
                            amount = 100.0
                        )
                    ),
                    lines = arrayListOf(
                        LineRequest(
                            minPricePerItem = 100.0,
                            costPricePerItem = 100.0,
                            basePricePerItem = 100.0,
                            quantity = 100.1.toDouble(),
                            discountedPricePerLine = 100.0,
                            lineId = "1",
                            lineNumber = 1,
                            discounts = arrayListOf(
                                DiscountRequest(
                                    promoCode = PromoCodeRequest(
                                        ids = Ids(
                                            "code" to "<Идентификатор промокода>"
                                        )
                                    ),
                                    amount = 100.0
                                ),
                                DiscountRequest(
                                    externalPromoAction = ExternalPromoActionRequest(
                                        Ids(
                                            "externalId" to "<Идентификатор промоакции>"
                                        )
                                    ),
                                    amount = 100.0
                                )
                            ),
                            customFields = CustomFields(
                                "<Имя доп поля 1>" to "<Значение доп поля>",
                                "<Имя доп поля 2>" to arrayListOf(
                                    "<Значение доп поля>",
                                    "<Значение доп поля>"
                                ),
                            ),
                            product = ProductRequest(
                                Ids(
                                    "website" to "<Id Product в Website>"
                                )
                            )
                        )
                    ),
                    email = "<Email>",
                    mobilePhone = "<Номер мобильного телефона без форматирования>"
                )
            )
        )
    }

    fun createUnauthorizedOrder() {
        Mindbox.executeAsyncOperation(
            context,
            operationSystemName = "Mobile.CreateAuthorizedOrder",
            operationBody = OperationBodyRequest(
                customer = CustomerRequest(
                    ids = Ids(
                        "website" to "myAwesomeWebsiteId"
                    ),
                    discountCard = DiscountCardRequest(
                        ids = Ids("number" to "123")
                    ),
                    birthDate = DateOnly(),
                    sex = Sex.FEMALE,
                    timeZone = TimeZone.getDefault(),
                    lastName = "<Фамилия>",
                    firstName = "<Имя>",
                    middleName = "<Отчество>",
                    area = AreaRequest(ids = Ids("externalId" to "<Внешний идентификатор зоны>")),

                    email = "<Email>",
                    mobilePhone = "<Мобильный телефон>",
                    customFields = CustomFields(
                        "<Имя доп поля 1>" to "<Значение доп поля>",
                        "<Имя доп поля 2>" to arrayListOf(
                            "<Значение доп поля>",
                            "<Значение доп поля>"
                        ),
                    ),
                    subscriptions = arrayListOf(
                        SubscriptionRequest(
                            brand = "<Системное имя бренда подписки клиента>",
                            pointOfContact = PointOfContactRequest.EMAIL,
                            topic = "<Внешний идентификатор тематики подписки>",
                            isSubscribed = true
                        )
                    )
                ),
                order = OrderRequest(
                    ids = Ids(
                        "websiteId" to "<Идентификатор заказа Идентификатор на сайте>"
                    ),
                    cashdesk = CashdeskRequest(
                        Ids(
                            "websiteId" to "<Идентификатор заказа Идентификатор на сайте>"
                        )
                    ),
                    deliveryCost = 100.0,
                    customFields = CustomFields(
                        "<Имя доп поля 1>" to "<Значение доп поля>",
                        "<Имя доп поля 2>" to arrayListOf(
                            "<Значение доп поля>",
                            "<Значение доп поля>"
                        ),
                    ),
                    area = AreaRequest(
                        Ids(
                            "externalId" to "<Внешний идентификатор зоны>"
                        )
                    ),
                    totalPrice = 100.0,
                    discounts = arrayListOf(
                        DiscountRequest(
                            promoCode = PromoCodeRequest(
                                ids = Ids(
                                    "code" to "<Идентификатор промокода>"
                                )
                            ),
                            amount = 100.0
                        ),
                        DiscountRequest(
                            externalPromoAction = ExternalPromoActionRequest(
                                Ids(
                                    "externalId" to "<Идентификатор промоакции>"
                                ),
                            ),
                            amount = 100.0
                        )
                    ),
                    lines = arrayListOf(
                        LineRequest(
                            minPricePerItem = 100.0,
                            costPricePerItem = 100.0,
                            basePricePerItem = 100.0,
                            quantity = 100.1.toDouble(),
                            discountedPricePerLine = 100.0,
                            lineId = "1",
                            lineNumber = 1,
                            discounts = arrayListOf(
                                DiscountRequest(
                                    promoCode = PromoCodeRequest(
                                        ids = Ids(
                                            "code" to "<Идентификатор промокода>"
                                        )
                                    ),
                                    amount = 100.0
                                ),
                                DiscountRequest(
                                    externalPromoAction = ExternalPromoActionRequest(
                                        Ids(
                                            "externalId" to "<Идентификатор промоакции>"
                                        )
                                    ),
                                    amount = 100.0
                                )
                            ),
                            customFields = CustomFields(
                                "<Имя доп поля 1>" to "<Значение доп поля>",
                                "<Имя доп поля 2>" to arrayListOf(
                                    "<Значение доп поля>",
                                    "<Значение доп поля>"
                                ),
                            ),
                            product = ProductRequest(
                                Ids(
                                    "website" to "<Id Product в Website>"
                                )
                            )
                        )
                    ),
                    email = "<Email>",
                    mobilePhone = "<Номер мобильного телефона без форматирования>"
                )
            )
        )
    }
}