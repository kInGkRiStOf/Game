/**
* Generated By NPCScript :: A scripting engine created for openrsc by Zilent
*/
package org.openrsc.server.npchandler.The_Jungle_Potion;
import org.openrsc.server.event.DelayedQuestChat;
import org.openrsc.server.event.SingleEvent;
import org.openrsc.server.model.ChatMessage;
import org.openrsc.server.model.InvItem;
import org.openrsc.server.model.MenuHandler;
import org.openrsc.server.model.Npc;
import org.openrsc.server.model.Player;
import org.openrsc.server.model.Quest;
import org.openrsc.server.model.World;
import org.openrsc.server.npchandler.NpcHandler;
public class Trufitus implements NpcHandler {
	public void handleNpc(final Npc npc, final Player owner) throws Exception {
		npc.blockedBy(owner);
		owner.setBusy(true);
		Quest q = owner.getQuest(39);
		if(q != null) {
			if(q.finished()) {
				questFinished(npc, owner);
			} else {
				switch(q.getStage()) {
					case 0:
						snakeWeed(npc, owner);
						break;
					case 1:
						ardrigal(npc, owner);
						break;
					case 2:
						sitoFoil(npc, owner);
						break;
					case 3:
						volenciaMoss(npc, owner);
						break;
					case 4:
						roguesPurse(npc, owner);
						break;
				}
			}
		} else {
			questNotStarted(npc, owner);
		}
	}
	
	private void questFinished(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"My greatest respects Bwana", "I have communed with the gods", "and the future looks good for my people", "We are happy now that the gods are not angry with us", "With some blessings we will be safe here."}, true) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}
	
	private void questNotStarted(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Greetings Bwana.", "I am Trufitus Shakaya of the", "Tai Bwo Wannai Village", "Welcome to our humble settlement."}, true) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options14 = {"What does Bwana mean?", "Tai Bwo Wannai? What does that mean?", "It's a nice village. Where is everyone?"};
						owner.setBusy(false);
						owner.sendMenu(options14);
						owner.setMenuHandler(new MenuHandler(options14) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										bwana(npc, owner);
										break;
									case 1:
										mean(npc, owner);
										break;
									case 2:
										everyone(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void everyone(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"They have returned to the jungle", "I need to commune with my gods", "to see what fate befalls us", "You may be able to help with this"}) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options15 = {"Me! How can I help?", "I am sorry, but I don't have time for that."};
						owner.setBusy(false);
						owner.sendMenu(options15);
						owner.setMenuHandler(new MenuHandler(options15) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										iHelp(npc, owner);
										break;
									case 1:
										noTime(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void noTime(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Very well then Bwana", "may your journeys bring you much joy", "maybe you will pass this way again and", "you will then take up my proposal", "but for now, farewell !"}) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void mean(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"It means 'small clearing in the jungle'", "But now it is the name of our village."}) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options16 = {"It is a nice village. Where is everyone?", "I am sorry, but I am very busy"};
						owner.setBusy(false);
						owner.sendMenu(options16);
						owner.setMenuHandler(new MenuHandler(options16) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										everyone(npc, owner);
										break;
									case 1:
										noTime(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void bwana(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Gracious sir, it means 'friend'", "And friends come in peace", "I assume that you come in peace?"}) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options17 = {"Yes, of course I do.", "What does a warrior like me know about peace?"};
						owner.setBusy(false);
						owner.sendMenu(options17);
						owner.setMenuHandler(new MenuHandler(options17) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										ofCourse(npc, owner);
										break;
									case 1:
										whatDoes(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void ofCourse(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Well, that is good news", "as I may have a proposition for you"}) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options18 = {"A proposition eh, sounds interesting!", "I am sorry, but I am very busy"};
						owner.setBusy(false);
						owner.sendMenu(options18);
						owner.setMenuHandler(new MenuHandler(options18) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										proposition(npc, owner);
										break;
									case 1:
										noTime(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void whatDoes(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"When you grow weary of violence", "and seek a more enlightened path", "please pay me a visit", "as I may have a proposal for you", "Now I need to attend to the plight", "of my people, please excuse me"}) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void proposition(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"I hoped that you would think so", "My people are afraid to stay in the village.", "They have returned to the jungle", "I need to commune with the gods", "to see what fate befalls us", "you could help me by collecting", "some herbs that I need."}) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options19 = {"Me! How can I help?", "I am very sorry, but I don't have time for that at the moment."};
						owner.setBusy(false);
						owner.sendMenu(options19);
						owner.setMenuHandler(new MenuHandler(options19) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										iHelp(npc, owner);
										break;
									case 1:
										noTime(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void iHelp(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"I need to make a special brew", "A potion that helps me to commune with the gods.", "For this potion, I need very", "special herbs that are only found in", "deep jungle", "I can guide you only so far as the", "herbs are not easy to find", "With some luck, you will find each herb in turn", "and bring it to me. I will give you", "details of where to find the next herb.", "In return I will give you training in Herblaw"}) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options20 = {"Hmm, sounds difficult, I don't know if I am ready for the challenge", "It sounds like just the challenge for me!"};
						owner.setBusy(false);
						owner.sendMenu(options20);
						owner.setMenuHandler(new MenuHandler(options20) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										difficult(npc, owner);
										break;
									case 1:
										challenge(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void difficult(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Very well then Bwana", "Maybe you will return to me invigorated", "and ready to take up the challenge one day ?"}) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void challenge(final Npc npc, final Player owner) {
		World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"And it would make a nice break from killing things !"}) {
			public void finished() {
				World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"That is excellent then Bwana!", "The first herb I need you to gather is called", "'Snake Weed'", "It grows near vines in an area to the south west", "where the ground turns soft and water kisses your feet."}) {
					public void finished() {
						owner.addQuest(39, 1);
						owner.setBusy(false);
						npc.unblock();
					}
				});
			}
		});
	}
	private void snakeWeed(final Npc npc, final Player owner) {
		npc.blockedBy(owner);
		owner.setBusy(true);
		final String[] messages0 = {"Hello Bwana, do you have the Snake Weed?"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages0, true) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options0 = {"Of course!", "Not yet. Sorry. what's the clue again?"};
						owner.setBusy(false);
						owner.sendMenu(options0);
						owner.setMenuHandler(new MenuHandler(options0) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										if(owner.getInventory().countId(816) > 0) {
											yesHasSnakeWeed(npc, owner);
										} else {
											yesNoHasSnakeWeed(npc, owner);
										}
										break;
									case 1:
										noSnakeWeed(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void noSnakeWeed(final Npc npc, final Player owner) {
		final String[] messages1 = {"It is related to the palm and grows", "well to the north in its brother's shady profusion."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages1) {
			public void finished() {
				needSnakeWeed(npc, owner);
			}
		});
	}

	private void needSnakeWeed(final Npc npc, final Player owner) {
		final String[] messages2 = {"I really need that Snake Weed if I am to make this potion"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages2) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void yesHasSnakeWeed(final Npc npc, final Player owner) {
		final String[] messages3 = {"Great, you have the 'Snake Weed'", "Ok the next herb is called, 'Ardrigal'", "It is related to the palm and grows", "to the East in its brother's shady profusion."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages3) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						owner.sendMessage("You give the Snake Weed to Trufitus");
						final String[] messages4 = {"Many thanks for the 'Snake Weed'"};
						World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages4) {
							public void finished() {
								owner.incQuestCompletionStage(39);
								owner.getInventory().remove(new InvItem(816, 1));
								owner.sendInventory();
								owner.setBusy(false);
								npc.unblock();
							}
						});
					}
				});
			}
		});
	}

	private void yesNoHasSnakeWeed(final Npc npc, final Player owner) {
		final String[] messages5 = {"Please don't try to deceive me!"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages5) {
			public void finished() {
				needSnakeWeed(npc, owner);
			}
		});
	}

	private void ardrigal(final Npc npc, final Player owner) {
		npc.blockedBy(owner);
		owner.setBusy(true);
		final String[] messages0 = {"Hello again, have you been able to get the Ardrigal?"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages0, true) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options0 = {"Of course!", "Not yet, sorry."};
						owner.setBusy(false);
						owner.sendMenu(options0);
						owner.setMenuHandler(new MenuHandler(options0) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										if(owner.getInventory().countId(818) > 0) {
											yesHasArdrigal(npc, owner);
										} else {
											yesNoHasArdrigal(npc, owner);
										}
										break;
									case 1:
										noArdrigal(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void noArdrigal(final Npc npc, final Player owner) {
		final String[] messages1 = {"I still require Ardrigal."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages1) {
			public void finished() {
				incomplete(npc, owner);
			}
		});
	}

	private void incomplete(final Npc npc, final Player owner) {
		final String[] messages2 = {"This potion will remain incomplete without it."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages2) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void yesHasArdrigal(final Npc npc, final Player owner) {
		final String[] messages3 = {"Ah, I see you have found the 'Ardrigal'", "you are doing well Bwana, the next", "herb is called, 'Sito Foil' and grows best", "where the ground has been blackened", "by the living flame."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages3) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						owner.sendMessage("You give the Ardrigal to Trufitus");
						owner.incQuestCompletionStage(39);
						owner.getInventory().remove(new InvItem(818, 1));
						owner.sendInventory();
						owner.setBusy(false);
						npc.unblock();
					}
				});
			}
		});
	}

	private void yesNoHasArdrigal(final Npc npc, final Player owner) {
		final String[] messages4 = {"Please don't try to deceive me!"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages4) {
			public void finished() {
				incomplete(npc, owner);
			}
		});
	}

	private void sitoFoil(final Npc npc, final Player owner) {
		npc.blockedBy(owner);
		owner.setBusy(true);
		final String[] messages0 = {"Greetings Bwana", "have you been successful in getting Sito Foil?"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages0, true) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options0 = {"Of course!", "Not yet, sorry."};
						owner.setBusy(false);
						owner.sendMenu(options0);
						owner.setMenuHandler(new MenuHandler(options0) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										if(owner.getInventory().countId(820) > 0) {
											yesHasSitoFoil(npc, owner);
										} else {
											yesNoHasSitoFoil(npc, owner);
										}
										
										break;
									case 1:
										noSitoFoil(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void noSitoFoil(final Npc npc, final Player owner) {
		final String[] messages1 = {"I still require Sito Foil, evrey herb is vital."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages1) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void yesHasSitoFoil(final Npc npc, final Player owner) {
		final String[] messages2 = {"Well done Bwana, just two more herbs", "to collect. The next herb is called, 'Volencia Moss'", "And it clings to rocks for it's existence", "It is difficult to see, so you must search for it well."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages2) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						owner.sendMessage("You give the Sito Foil to Trufitus");
						owner.incQuestCompletionStage(39);
						owner.getInventory().remove(new InvItem(820, 1));
						owner.sendInventory();
						owner.setBusy(false);
						npc.unblock();
					}
				});
			}
		});
	}

	private void yesNoHasSitoFoil(final Npc npc, final Player owner) {
		final String[] messages3 = {"Please don't try to deceive me!"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages3) {
			public void finished() {
				noSitoFoil(npc, owner);
			}
		});
	}
	
	private void volenciaMoss(final Npc npc, final Player owner) {
		npc.blockedBy(owner);
		owner.setBusy(true);
		final String[] messages0 = {"Greetings Bwana", "Do you have the 'Volencia Moss'?"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages0, true) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options0 = {"Of course!", "Not yet, sorry."};
						owner.setBusy(false);
						owner.sendMenu(options0);
						owner.setMenuHandler(new MenuHandler(options0) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										if(owner.getInventory().countId(822) > 0) {
											yesHasVolenciaMoss(npc, owner);
										} else {
											yesNoHasVolenciaMoss(npc, owner);
										}
										break;
									case 1:
										noVolenciaMoss(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void yesHasVolenciaMoss(final Npc npc, final Player owner) {
		final String[] messages1 = {"Ah, Volencia Moss, beautiful!", "One final herb and the potion will", "ce complete. This is the most difficult to", "find as it inhabits the darkness of the", "underground. It is called 'Rogues Purse'", "And is found in the darkest place on the island", "A secret entrance to the cavern is set into", "the Northern cliffs of this land", "Take care Bwana as it may be very dangerous"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages1) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						owner.sendMessage("You give the Volencia Moss to Trufitus");
						owner.incQuestCompletionStage(39);
						owner.getInventory().remove(new InvItem(822, 1));
						owner.sendInventory();
						owner.setBusy(false);
						npc.unblock();
					}
				});
			}
		});
	}

	private void yesNoHasVolenciaMoss(final Npc npc, final Player owner) {
		final String[] messages2 = {"Please don't try to deceive me!"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages2) {
			public void finished() {
				noVolenciaMoss(npc, owner);
			}
		});
	}

	private void noVolenciaMoss(final Npc npc, final Player owner) {
		final String[] messages3 = {"I know it is difficult to find, but I do need Volencia Moss", "After that herb, you only have one more to find."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages3) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}
	
	private void roguesPurse(final Npc npc, final Player owner) throws Exception {
		npc.blockedBy(owner);
		owner.setBusy(true);
		final String[] messages0 = {"Have you found 'Rogues Purse'?"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages0, true) {
			public void finished() {
				World.getDelayedEventHandler().add(new SingleEvent(owner, 1500) {
					public void action() {
						final String[] options0 = {"Yes sir, indeedy I do!", "Not yet, sorry"};
						owner.setBusy(false);
						owner.sendMenu(options0);
						owner.setMenuHandler(new MenuHandler(options0) {
							public void handleReply(final int option, final String reply) {
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView()) {
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) {
									case 0:
										if(owner.getInventory().countId(824) > 0) {
											yesHasRoguesPurse(npc, owner);
										} else {
											yesNoHasRoguesPurse(npc, owner);
										}
										
										break;
									case 1:
										noRoguesPurse(npc, owner);
										break;
								}
							}
						});
					}
				});
			}
		});
	}

	private void noRoguesPurse(final Npc npc, final Player owner) {
		final String[] messages1 = {"Rogues Purse is the last herb", "for the potion and possibly the most", "difficult to find but I do need it."};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages1) {
			public void finished() {
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void yesHasRoguesPurse(final Npc npc, final Player owner) {
		final String[] messages2 = {"Most excellent Bwana!", "You have returned all the herbs to me", "and I can now finish the preparations", "for the potion and thankfully divine with the gods.", "Many blessings on you!", "I must now prepare", "please excuse me while I make the arrangements"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages2) {
			public void finished() {
				owner.getInventory().remove(new InvItem(824, 1));
				owner.sendInventory();
				owner.sendMessage("You give the Rogues Purse to Trufitus");
				owner.sendMessage("Trufitus shows you some techniques in Herblaw");
				owner.sendMessage("You gain experience in Herblaw!");
				owner.incQuestExp(15, 3000);
				owner.finishQuest(39);
				owner.sendMessage("@gre@You have gained 1 quest point!");
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}

	private void yesNoHasRoguesPurse(final Npc npc, final Player owner) {
		final String[] messages3 = {"Please don't try to deceive me!"};
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, messages3) {
			public void finished() {
				noRoguesPurse(npc, owner);
			}
		});
	}
}