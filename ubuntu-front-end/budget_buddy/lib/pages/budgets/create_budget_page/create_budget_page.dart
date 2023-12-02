import 'dart:html';

import 'package:budget_buddy/models/budget.dart';
import 'package:budget_buddy/pages/budgets/create_budget_page/budget_parallax_position.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class CreateBudgetPage extends StatefulWidget {
  const CreateBudgetPage({super.key});

  @override
  State<CreateBudgetPage> createState() => _CreateBudgetPageState();
}

class _CreateBudgetPageState extends State<CreateBudgetPage> {
  List<String> images = [
    "/images/background_image_1.jpg",
    "/images/background_image_2.jpg",
    "/images/background_image_3.jpg"
  ];
  double budgetImageTopPosition = 0.0;
  double budgetTreeTopPosition = 0.0;
  var _selectedSpendingCategory = "Investment";

  List<String> _spendingCategories = ["Item1", "Item2", "Item3", "Item4"];

  GlobalKey<FormState> _globalKey = GlobalKey<FormState>();

  final _budget = Budget(
      userId: 1,
      id: 1,
      name: "",
      amountLimit: 0.0,
      periodType: DateTime.now(),
      budgetTotal: 0.0,
      budgetMotto: "");

  void _saveBudget() {
    if (_globalKey.currentState!.validate()) {
      _globalKey.currentState!.save();
      print(_budget.name);
      print(_selectedSpendingCategory);
      Navigator.of(context).pop(_budget);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        //color: Colors.amber[200],
        child: Stack(
          children: [
            Form(
              key: _globalKey,
              child: Column(
                children: [
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextFormField(
                      maxLength: 50,
                      decoration: const InputDecoration(
                          label: Text("Budget Name"),
                          icon: Icon(Icons.person),
                          hintText: "Let's name your budget!"),
                      onSaved: (newValue) {
                        _budget.name = newValue.toString();
                      },
                    ),
                  ),
                  const Divider(
                    indent: 18,
                    endIndent: 18,
                  ),
                  const Text("INCOME"),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextFormField(
                      maxLength: 10,
                      decoration: const InputDecoration(
                          label: Text("Expected Monthly Income"),
                          icon: Icon(Icons.monetization_on_rounded),
                          hintText: "What is your Income?"),
                    ),
                  ),
                  const Divider(
                    indent: 18,
                    endIndent: 18,
                  ),
                  const Text("SPENDING"),
                  Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Row(
                        crossAxisAlignment: CrossAxisAlignment.end,
                        children: [
                          Expanded(
                            child: TextFormField(
                              validator: (value) {
                                if (value == null ||
                                    value.isEmpty ||
                                    int.tryParse(value) == null ||
                                    int.tryParse(value)! <= 0) {
                                  return "Input must be a number";
                                }
                              },
                              decoration: const InputDecoration(
                                  label: Text("Expected Monthly Cost 1"),
                                  icon: Icon(Icons.monetization_on_rounded),
                                  hintText: "Let's get your monthly expenses"),
                            ),
                          ),
                          Expanded(
                            child: DropdownButtonFormField(
                                value:
                                    _selectedSpendingCategory, //Need to initialise this value to a budget category from the model
                                items: const [
                                  DropdownMenuItem(
                                    child: Text("Recurring Cost"),
                                    value: "Big Spending",
                                  ),
                                  DropdownMenuItem(
                                    child: Text("Once-Off Cost"),
                                    value: "Small Spending",
                                  ),
                                  DropdownMenuItem(
                                    child: Text("Investment"),
                                    value: "Investment",
                                  ),
                                ],
                                onChanged: (value) {
                                  setState(() {
                                    _selectedSpendingCategory = value!;
                                  });
                                }),
                          ),
                        ],
                      )),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: TextFormField(
                      maxLength: 20,
                      decoration: const InputDecoration(
                          label: Text("Expected Monthly Cost 2"),
                          icon: Icon(Icons.monetization_on_rounded),
                          hintText: "Let's get your monthly expenses"),
                    ),
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      ElevatedButton(
                          onPressed: () {
                            _globalKey.currentState!.reset();
                          },
                          child: const Text("Reset")),
                      const SizedBox(
                        width: 8,
                      ),
                      ElevatedButton(
                          onPressed: _saveBudget,
                          child: const Text("Create Budget"))
                    ],
                  )
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}

Future<http.Response> fetchBudget() {
  return http.get(Uri.parse('https://jsonplaceholder.typicode.com/albums/1'));
}

//PARALLAX WIDGET

// return Scaffold(
//       body: NotificationListener(
//           onNotification: (notification) {
//             if (notification is ScrollUpdateNotification) {
//               if (notification.scrollDelta == null) {
//                 return true;
//               }
//               setState(() {
//                 budgetImageTopPosition -= notification.scrollDelta! / 2.0;
//                 budgetTreeTopPosition -= notification.scrollDelta! / 1.5;
//                 //print(notification.scrollDelta);
//               });
//             }
//             return true;
//           },
//           child: Stack(
//             children: [
//               ParallaxPosition(
//                 asset: "/images/budget_image.jpg",
//                 top: budgetImageTopPosition,
//                 left: 0.0,
//                 right: 0.0,
//               ),
//               // ParallaxPosition(
//               //   asset: "/images/money_tree_image.png",
//               //   top: budgetTreeTopPosition,
//               //   left: 0.0,
//               //   right: 200.0,
//               // ),
//               SingleChildScrollView(
//                 physics: const ClampingScrollPhysics(),
//                 child: Column(
//                   children: [
//                     const SizedBox(
//                       height: 150,
//                     ),
//                     Container(
//                       height: MediaQuery.of(context).size.height,
//                       width: MediaQuery.of(context).size.width,
//                       alignment: Alignment.center,
//                       child: Container(
//                           // decoration: const BoxDecoration(
//                           //   image: DecorationImage(
//                           //     opacity: 1,
//                           //     fit: BoxFit.cover,
//                           //     image:
//                           //         AssetImage("/images/background_image_1.jpg"),
//                           //   ),
//                           // ),
//                           child: Container(
//                         margin: const EdgeInsets.all(10.0),
//                         child: Column(
//                           children: [
//                             Row(
//                               mainAxisAlignment: MainAxisAlignment.spaceBetween,
//                               children: [
//                                 Column(
//                                   children: [
//                                     Container(
//                                       width: 150,
//                                       height: 50,
//                                       color: Colors.amber,
//                                     )
//                                   ],
//                                 ),
//                               ],
//                             ),
//                             const Stack(
//                               children: [
//                                 RotatedBox(
//                                   quarterTurns: 2,
//                                   child: Icon(Icons.airplanemode_active),
//                                 ),
//                               ],
//                             )
//                           ],
//                         ),
//                       )),
//                     )
//                   ],
//                 ),
//               )
//             ],
//           )),
//     );
