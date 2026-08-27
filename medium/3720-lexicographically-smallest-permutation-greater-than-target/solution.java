                            freq[x]--;
                        }
                    }

                    return new String(ans);
                }
            }

            // Restore target[i]
            freq[t]++;
        }

        return "";
    }
}
