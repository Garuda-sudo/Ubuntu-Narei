import 'package:budget_buddy/pages/landing_page/widgets/landing_page_graph_component.dart';
import 'package:flutter/material.dart';

class AccountPage extends StatefulWidget {
  const AccountPage({super.key});

  @override
  State<AccountPage> createState() => _AccountPageState();
}

class _AccountPageState extends State<AccountPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          const LandingPageGraphComponent(),
          const SizedBox(
            height: 20.0,
          ),
          const Padding(
            padding: EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                Text(
                  'Accounts',
                  style: TextStyle(fontWeight: FontWeight.bold),
                )
              ],
            ),
          ),
          Expanded(
            child: Container(
              child: ListView.builder(
                  itemCount: 5,
                  itemBuilder: (BuildContext context, int index) {
                    return Padding(
                      padding: const EdgeInsets.all(10.0),
                      child: Container(
                        decoration: BoxDecoration(
                            borderRadius:
                                const BorderRadius.all(Radius.circular(20)),
                            boxShadow: const [
                              BoxShadow(
                                  color: Colors.grey, offset: Offset(2.0, 2.0))
                            ],
                            color: Colors.grey.shade200),
                        //color: Colors.blue,
                        height: 100,
                      ),
                    );
                  }),
            ),
          )
        ],
      ),
    );
  }
}
