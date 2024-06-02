# ISD.ICT.20232 Group 9

# Team member
| Name             | Student ID  | Role        |
| :--------------- | :---------- | :---------- |
| Lê Xuân Hiếu     | 20215201    | Team Leader |
| Nguyễn Hà Hiếu   | 20215202    | Member      |
| Nguyễn Mạnh Hiếu | 20215203    | Member      |
| Nguyễn Văn Hiếu  | 20215204    | Member      |
| Phạm Trung Hiếu  | 20215205    | Member      |

## Technology
Java + JavaFx

## How to install
1. Install JavaFx 22.0.1 .
2. Create a new `User Library` under `Eclipse` -> `Window` -> `Preferences` -> `Java` -> `Build Path` -> `User Libraries` -> `New`
3. Name it anything you want, and include all **_jars_** under the extracted folder (Ex: "C:\Users\Admin\javafx-sdk-22.0.1\lib") that you downloaded in step 1.
4. Include the library into the classpath of the project (Right click on the project -> `Build path` -> `Configure Build Path` -> `Libraries` -> `Classpath`).

### Add VM arguments
Click on `Run` -> `Run Configurations...` -> `Java Application`, create a new launch configuration for your project and
add these VM arguments:

  > `--module-path <Your javafx lib folder address> --add-modules javafx.controls,javafx.graphics,javafx.fxml,javafx.media,javafx.web`

## Report Content
<details>
  <summary>From 20/05/2024 ~ to 26/05/2024 </summary>
<br>

<details>
<summary>Team Member 1: Lê Xuân Hiếu</summary>
<br>

- Assigned tasks:
  - Redesign, create skeleton code.

- Implementation details:
  - Pull Request(s): No PR (because creating init project)
  - Specific implementation details:
    - Create initial project.
    - Resolve conflicts between members.

</details>

<details>
<summary>Team Member 2: Nguyễn Hà Hiếu</summary>
<br>

- Assigned tasks: Implement the shipping and home screen

- Implementation details:
  - Pull Request(s): https://github.com/hieulexuan123/ISD.ICT.20232.09/pull/1
  - Specific implementation details:
    - Edit PlaceOrderController, DeliveryInfo
    - Edit order_screen.fxml, invoice_screen.fxml
</details>

<details>
<summary>Team Member 3: Nguyễn Mạnh Hiếu</summary>
<br>

- Assigned tasks: Implement the VNPay Subsystem and payment result screen

- Implementation details:
  - Pull Request(s): Already merged in the main branch
  - Specific implementation details:
    - Edit classes inside package subsystem.
</details>

<details>
<summary>Team Member 4: Nguyễn Văn Hiếu</summary>
<br>

- Assigned tasks: Implement the Cart page

- Implementation details:
  - Pull Request(s): Already merged in the main branch
  - Specific implementation details:
    - Create HomeScreen, FXMLScreenHandler.
    - Edit home.fxml, cart_screen.fxml, media_cart_screen.fxml, CartScreen.
</details>

<details>
<summary>Team Member 5: Phạm Trung Hiếu</summary>
<br>

- Assigned tasks: Set up JavaFx and create FXML pages
- Implementation details:
  - Pull Request(s): Already merge in the main branch
  - Specific implementation details:
    - Create all initial fxml files.
</details>
</details>
-------------------

<details>
  <summary>From 27/05/2024 ~ to 02/06/2024 </summary>
<br>

<details>
<summary>Team Member 1: Lê Xuân Hiếu</summary>
<br>

- Assigned tasks:
  - Fix all the bugs to make the app run.
  - Check coupling and cohesion related to cart

- Implementation details:
  - Pull Request(s): https://github.com/hieulexuan123/ISD.ICT.20232.09/pull/2, https://github.com/hieulexuan123/ISD.ICT.20232.09/pull/4 
  - Specific implementation details:
    - Fix all the bugs of all classes.
    - Check coupling and cohesion of CartScreen, CartItemScreen, Cart, CartMedia
</details>

<details>
<summary>Team Member 2: Nguyễn Hà Hiếu</summary>
<br>

- Assigned tasks: Check coupling related to shipping and invoice

- Implementation details:
  - Pull Request(s): https://github.com/hieulexuan123/ISD.ICT.20232.09/pull/3
  - Specific implementation details:
    - Check coupling of ShippingScreen and InvoiceScreen
    - Modify small details in DeliveryInfo
</details>

<details>
<summary>Team Member 3: Nguyễn Mạnh Hiếu</summary>
<br>

- Assigned tasks: Check coupling related to Vnpay subsystem

- Implementation details:
  - Pull Request(s): 
  - Specific implementation details:
   - ...
</details>

<details>
<summary>Team Member 4: Nguyễn Văn Hiếu</summary>
<br>

- Assigned tasks: Check cohesion related to Vnpay subsystem

- Implementation details:
  - Pull Request(s): 
  - Specific implementation details:
    - ...
</details>

<details>
<summary>Team Member 5: Phạm Trung Hiếu</summary>
<br>

- Assigned tasks: Check cohesion related to shipping and invoice
- Implementation details:
  - Pull Request(s): https://github.com/hieulexuan123/ISD.ICT.20232.09/pull/5
  - Specific implementation details:
    - Check cohesion of ShippingScreen, OrderItemScreen, InvoiceScreen, InvoiceItemScreen
</details>
</details>
